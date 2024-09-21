package dev.definedentity.astralgenerators.block.machines

import dev.definedentity.astralgenerators.block.AGBlock
import dev.definedentity.astralgenerators.block.multiblock_projector.MultiBlockProjector
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.core.BlockPos
import net.minecraft.core.Direction
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.block.state.StateDefinition
import net.minecraft.world.level.block.state.properties.BlockStateProperties
import net.minecraft.world.level.block.state.properties.BooleanProperty

class SteamTurbine : AGBlock(FabricBlockSettings.copy(Blocks.IRON_BLOCK)) {
    companion object {
        val ID = "steam_turbine"
        val NAME = "Steam Turbine Controller Dummy"
        val TOOLTIP_CONTENT = "Produce energy from steam"

        val FACING = BlockStateProperties.HORIZONTAL_FACING
        val ACTIVE = BooleanProperty.create("active")
    }

    init {
        registerDefaultState(
            with(defaultBlockState()) { setValue(MultiBlockProjector.FACING, Direction.NORTH) }
        )
        registerDefaultState(
            with(defaultBlockState()) { setValue(MultiBlockProjector.ACTIVE, false) }
        )
    }

    fun setFacing(level: Level, pos: BlockPos, facing: Direction) {
        level.setBlock(
            pos,
            level.getBlockState(pos).setValue(MultiBlockProjector.FACING, facing),
            3
        )
    }

    fun getFacing(state: BlockState): Direction {
        return state.getValue(MultiBlockProjector.FACING)
    }

    override fun setPlacedBy(
        level: Level,
        pos: BlockPos,
        state: BlockState,
        placer: LivingEntity?,
        stack: ItemStack
    ) {
        super.setPlacedBy(level, pos, state, placer, stack)

        if (placer !is Player) return
        setFacing(level, pos, placer.direction.opposite)
    }

    override fun createBlockStateDefinition(builder: StateDefinition.Builder<Block, BlockState>) {
        builder.add(FACING, ACTIVE)
    }

    override fun getTooltipContent(): String {
        return TOOLTIP_CONTENT
    }

    override fun getBlockId(): String {
        return ID
    }
}
