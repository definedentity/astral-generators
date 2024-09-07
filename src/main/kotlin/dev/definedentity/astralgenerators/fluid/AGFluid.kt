package dev.definedentity.astralgenerators.fluid

import net.minecraft.core.BlockPos
import net.minecraft.core.Direction
import net.minecraft.world.level.BlockGetter
import net.minecraft.world.level.LevelAccessor
import net.minecraft.world.level.LevelReader
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.material.FlowingFluid
import net.minecraft.world.level.material.Fluid
import net.minecraft.world.level.material.FluidState

abstract class AGFluid : FlowingFluid() {

    override fun canBeReplacedWith(
        state: FluidState,
        world: BlockGetter,
        pos: BlockPos,
        fluid: Fluid,
        direction: Direction
    ): Boolean {
        return false
    }

    override fun getTickDelay(world: LevelReader): Int {
        return 5
    }

    override fun getExplosionResistance(): Float {
        return 100f
    }

    override fun beforeDestroyingBlock(world: LevelAccessor, pos: BlockPos, state: BlockState) {
        val blockEntity = if (state.hasBlockEntity()) world.getBlockEntity(pos) else null
        Block.dropResources(state, world, pos, blockEntity)
    }

    override fun getSlopeFindDistance(world: LevelReader): Int {
        return 4
    }

    override fun getDropOff(world: LevelReader): Int {
        return 1
    }

    override fun isSame(fluid: Fluid): Boolean {
        return fluid === source || fluid === flowing
    }

    override fun canConvertToSource(): Boolean {
        return false
    }
}
