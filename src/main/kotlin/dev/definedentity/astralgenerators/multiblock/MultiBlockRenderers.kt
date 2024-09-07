package dev.definedentity.astralgenerators.multiblock

import com.mojang.blaze3d.vertex.DefaultVertexFormat
import com.mojang.blaze3d.vertex.PoseStack
import com.mojang.blaze3d.vertex.VertexConsumer
import com.mojang.blaze3d.vertex.VertexFormat
import com.mojang.math.Quaternion
import definedentity.xenon.render.RenderUtils
import definedentity.xenon.render.buffer.TransformingVertexConsumer
import definedentity.xenon.vec.Cuboid6
import definedentity.xenon.vec.Rotation
import dev.definedentity.astralgenerators.util.TimeKeeper.getClientTick
import java.util.*
import java.util.List
import kotlin.collections.ArrayList
import kotlin.collections.Map
import kotlin.collections.MutableList
import kotlin.collections.MutableMap
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.sin
import net.minecraft.client.Minecraft
import net.minecraft.client.renderer.MultiBufferSource
import net.minecraft.client.renderer.RenderStateShard
import net.minecraft.client.renderer.RenderStateShard.LineStateShard
import net.minecraft.client.renderer.RenderType
import net.minecraft.client.renderer.texture.OverlayTexture
import net.minecraft.core.BlockPos
import net.minecraft.core.Direction
import net.minecraft.world.entity.player.Player
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.state.BlockState

class MultiBlockRenderers {
    companion object {
        private val outlineType: RenderType =
            RenderType.create(
                "invalid_outline",
                DefaultVertexFormat.POSITION_COLOR_NORMAL,
                VertexFormat.Mode.LINES,
                256,
                RenderType.CompositeState.builder()
                    .setShaderState(RenderStateShard.RENDERTYPE_LINES_SHADER)
                    .setTransparencyState(RenderStateShard.TRANSLUCENT_TRANSPARENCY)
                    .setCullState(RenderStateShard.NO_CULL)
                    .setWriteMaskState(RenderStateShard.COLOR_WRITE)
                    .setDepthTestState(RenderStateShard.NO_DEPTH_TEST)
                    .setLineState(LineStateShard(OptionalDouble.of(4.0)))
                    .createCompositeState(false)
            )

        fun renderBuildGuide(
            level: Level,
            inWorldOrigin: BlockPos,
            poseStack: PoseStack,
            getter: MultiBufferSource,
            structure: MultiBlockDefinition,
            packedLight: Int,
            partialTicks: Float,
            direction: Direction
        ) {
            val blocks: Map<BlockPos, MultiBlockPart> = structure.getBlocks(getRotationFromDirection(direction))
            val stateMap: MutableMap<MultiBlockPart?, BlockState> = IdentityHashMap()
            val player: Player? = Minecraft.getInstance().player

            var time = getClientTick() % 80
            var anim = 5
            if (time >= 70) {
                time -= 70
                anim += (sin((time / 10f) * Math.PI) * 5).toInt()
            }

            val invalidBlocks: MutableList<BlockPos> = ArrayList()
            for (pos in blocks.keys) {
                val part = blocks[pos]
                if (part!!.validBlocks().isEmpty()) continue
                val worldPos = inWorldOrigin.offset(pos)

                if (level.isEmptyBlock(worldPos)) {
                    if (player != null && worldPos.distToCenterSqr(player.eyePosition) < (2 * 2))
                        continue
                    val state =
                        stateMap.computeIfAbsent(part) { e: MultiBlockPart? ->
                            List.copyOf(e!!.validBlocks())[
                                    (getClientTick() / 40) % e.validBlocks().size]
                                .defaultBlockState()
                        }
                    if (state.isAir) continue
                    poseStack.pushPose()
                    poseStack.translate(pos.x + 0.1, pos.y + 0.1, pos.z + 0.1)
                    poseStack.scale(0.8f, 0.8f, 0.8f)
                    Minecraft.getInstance()
                        .blockRenderer
                        .renderSingleBlock(
                            state,
                            poseStack,
                            getter,
                            packedLight,
                            OverlayTexture.pack(anim, 10)
                        )
                    poseStack.popPose()
                } else if (!part.isMatch(level, worldPos)) {
                    invalidBlocks.add(pos)
                }
            }

            if (getter is MultiBufferSource.BufferSource) {
                getter.endBatch()
            }

            if (invalidBlocks.isNotEmpty()) {
                for (pos in invalidBlocks) {
                    poseStack.pushPose()
                    poseStack.translate(pos.x + 0.5, pos.y + 0.5, pos.z + 0.5)
                    val builder: VertexConsumer =
                        TransformingVertexConsumer(getter.getBuffer(outlineType), poseStack)
                    var invalidAnim = sin((getClientTick() + partialTicks) / 25.0 * 3.141593)
                    invalidAnim = max(0.1, abs(invalidAnim))
                    val box = Cuboid6().expand(invalidAnim / 2)
                    RenderUtils.bufferCuboidOutline(builder, box, 1f, 0f, 0f, 1f)
                    poseStack.popPose()
                }
            }
        }

        private fun getRotationFromDirection(direction: Direction): Rotation {
            return when (direction) {
                Direction.EAST -> Rotation(0.0, 0.0, 1.0, 0.0)
                Direction.SOUTH -> Rotation(Math.PI / 2, 0.0, 1.0, 0.0)
                Direction.WEST -> Rotation(Math.PI, 0.0, 1.0, 0.0)
                Direction.NORTH -> Rotation(-Math.PI / 2, 0.0, 1.0, 0.0)
                else -> Rotation(0.0, 0.0, 1.0, 0.0)
            }
        }
    }
}
