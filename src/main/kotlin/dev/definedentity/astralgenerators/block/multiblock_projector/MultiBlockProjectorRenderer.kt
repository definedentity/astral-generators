package dev.definedentity.astralgenerators.block.multiblock_projector

import com.mojang.blaze3d.vertex.PoseStack
import dev.definedentity.astralgenerators.AstralGenerators
import dev.definedentity.astralgenerators.multiblock.MultiBlockManager
import dev.definedentity.astralgenerators.multiblock.MultiBlockRenderers
import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment
import net.minecraft.client.renderer.MultiBufferSource
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider
import net.minecraft.resources.ResourceLocation

@Environment(EnvType.CLIENT)
class MultiBlockProjectorRenderer(ctx: BlockEntityRendererProvider.Context) :
    BlockEntityRenderer<MultiBlockProjectorEntity> {
    override fun render(
        blockEntity: MultiBlockProjectorEntity,
        partialTick: Float,
        poseStack: PoseStack,
        bufferSource: MultiBufferSource,
        packedLight: Int,
        packedOverlay: Int
    ) {
        if (!blockEntity.blockState.getValue(MultiBlockProjector.ACTIVE)) return
        val multiblockType =
            blockEntity.blockState.getValue(MultiBlockProjector.MULTIBLOCK_TYPE).serializedName
        val multiblockDefinition =
            MultiBlockManager.getDefinition(
                ResourceLocation(AstralGenerators.MOD_ID, multiblockType)
            )!!

        MultiBlockRenderers.renderBuildGuide(
            blockEntity.level!!,
            blockEntity.blockPos,
            poseStack,
            bufferSource,
            multiblockDefinition,
            200,
            partialTick,
            blockEntity.blockState.getValue(MultiBlockProjector.FACING)
        )
    }
}
