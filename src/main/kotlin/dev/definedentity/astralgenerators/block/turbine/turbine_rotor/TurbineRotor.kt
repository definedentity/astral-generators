package dev.definedentity.astralgenerators.block.turbine.turbine_rotor

import dev.definedentity.astralgenerators.block.AGBlock
import dev.definedentity.astralgenerators.block.machines.SolidBoiler
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.core.BlockPos
import net.minecraft.core.Direction
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.context.BlockPlaceContext
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.DirectionalBlock
import net.minecraft.world.level.block.Mirror
import net.minecraft.world.level.block.Rotation
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.block.state.StateDefinition
import net.minecraft.world.level.block.state.properties.BlockStateProperties

class TurbineRotor: AGBlock(FabricBlockSettings.copy(Blocks.IRON_BLOCK)) {
    companion object {
        val ID = "turbine_rotor"
        val NAME = "Turbine Rotor"
        val TOOLTIP_CONTENT = "An important component of the turbine"

        val FACING = DirectionalBlock.FACING
    }

    init {
        registerDefaultState(with(defaultBlockState()) { setValue(FACING, Direction.NORTH) })
    }

    override fun createBlockStateDefinition(builder: StateDefinition.Builder<Block, BlockState>) {
        builder.add(FACING)
    }

    override fun getStateForPlacement(context: BlockPlaceContext): BlockState? {
        return defaultBlockState().setValue(FACING, context.nearestLookingDirection.opposite)
    }

    override fun rotate(state: BlockState, rotation: Rotation): BlockState? {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)))
    }

    override fun mirror(state: BlockState, mirror: Mirror): BlockState? {
        return state.rotate(mirror.getRotation(state.getValue(FACING)))
    }

    override fun getBlockId(): String {
        return ID
    }

    override fun getTooltipContent(): String {
        return TOOLTIP_CONTENT
    }
}