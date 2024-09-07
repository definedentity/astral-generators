package dev.definedentity.astralgenerators.block.multiblock_projector

import dev.definedentity.astralgenerators.block.AGBaseEntityBlock
import dev.definedentity.astralgenerators.multiblock.MultiBlockType
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.ChatFormatting
import net.minecraft.core.BlockPos
import net.minecraft.core.Direction
import net.minecraft.network.chat.TranslatableComponent
import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResult
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.Items
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.RenderShape
import net.minecraft.world.level.block.entity.BlockEntity
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.block.state.StateDefinition
import net.minecraft.world.level.block.state.properties.BlockStateProperties
import net.minecraft.world.level.block.state.properties.BooleanProperty
import net.minecraft.world.level.block.state.properties.EnumProperty
import net.minecraft.world.phys.BlockHitResult

class MultiBlockProjector : AGBaseEntityBlock(FabricBlockSettings.copy(Blocks.IRON_BLOCK)) {
    companion object {
        val ID = "multiblock_projector"
        val NAME = "MultiBlock Projector"
        val TOOLTIP_CONTENT = "A projector that renders multiblocks hologram"

        val ENABLE_MESSAGE_KEY = "multiblock_projector.enable"
        val ENABLE_MESSAGE = "Multiblock Projector enabled"
        val DISABLE_MESSAGE_KEY = "multiblock_projector.disable"
        val DISABLE_MESSAGE = "Multiblock Projector disabled"

        val FACING = BlockStateProperties.HORIZONTAL_FACING
        val ACTIVE = BooleanProperty.create("active")
        val MULTIBLOCK_TYPE = EnumProperty.create("multiblock_type", MultiBlockType::class.java)
    }

    init {
        registerDefaultState(with(defaultBlockState()) { setValue(FACING, Direction.NORTH) })
        registerDefaultState(with(defaultBlockState()) { setValue(ACTIVE, false) })
        registerDefaultState(
            with(defaultBlockState()) { setValue(MULTIBLOCK_TYPE, MultiBlockType.FUSION_REACTOR) }
        )
    }

    override fun createBlockStateDefinition(builder: StateDefinition.Builder<Block, BlockState>) {
        builder.add(FACING, ACTIVE, MULTIBLOCK_TYPE)
    }

    override fun newBlockEntity(pos: BlockPos, state: BlockState): BlockEntity {
        return MultiBlockProjectorEntity(pos, state)
    }

    override fun getTooltipContent(): String {
        return TOOLTIP_CONTENT
    }

    override fun getBlockId(): String {
        return ID
    }

    override fun getRenderShape(state: BlockState): RenderShape {
        return RenderShape.MODEL
    }

    fun setFacing(level: Level, pos: BlockPos, facing: Direction) {
        level.setBlock(pos, level.getBlockState(pos).setValue(FACING, facing), 3)
    }

    fun getFacing(state: BlockState): Direction {
        return state.getValue(FACING)
    }

    override fun setPlacedBy(level: Level, pos: BlockPos, state: BlockState, placer: LivingEntity?, stack: ItemStack) {
        super.setPlacedBy(level, pos, state, placer, stack)

        if(placer !is Player) return
        setFacing(level, pos, placer.direction)
    }

    override fun use(
        state: BlockState,
        level: Level,
        pos: BlockPos,
        player: Player,
        hand: InteractionHand,
        hit: BlockHitResult
    ): InteractionResult {
        if (level.isClientSide) return InteractionResult.PASS
        if (hand != InteractionHand.MAIN_HAND) return InteractionResult.PASS
        if (player.getItemInHand(hand).item != Items.AIR) return InteractionResult.PASS

        if (player.isDiscrete) {
            val currentType = state.getValue(MULTIBLOCK_TYPE)
            val allTypes = MultiBlockType.entries.toTypedArray()
            val currentIndex = allTypes.indexOf(currentType)
            val newIndex = (currentIndex + 1) % allTypes.size
            val newType = allTypes[newIndex]

            level.setBlock(pos, state.setValue(MULTIBLOCK_TYPE, newType), 3)
            player.displayClientMessage(
                TranslatableComponent(
                    newType.serializedName.split("_").joinToString(" ") {
                        it.replaceFirstChar { char -> char.uppercase() }
                    }
                ),
                true
            )
        } else {
            val currentActive = state.getValue(ACTIVE)
            val newActive = !currentActive

            if (newActive) {
                level.setBlock(pos, state.setValue(ACTIVE, true), 3)
                player.displayClientMessage(
                    TranslatableComponent(ENABLE_MESSAGE_KEY).withStyle(ChatFormatting.GREEN),
                    true
                )
                return InteractionResult.PASS
            }

            level.setBlock(pos, state.setValue(ACTIVE, false), 3)
            player.displayClientMessage(
                TranslatableComponent(DISABLE_MESSAGE_KEY).withStyle(ChatFormatting.RED),
                true
            )
        }

        return InteractionResult.PASS
    }
}
