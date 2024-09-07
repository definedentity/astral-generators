package dev.definedentity.astralgenerators.fluid

import dev.definedentity.astralgenerators.registry.FluidRegistry
import dev.definedentity.astralgenerators.registry.ItemRegistry
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.block.state.StateDefinition
import net.minecraft.world.level.block.state.properties.BlockStateProperties
import net.minecraft.world.level.material.Fluid
import net.minecraft.world.level.material.FluidState

abstract class Deuterium : AGFluid() {
    companion object {
        val ID = "deuterium"
        val NAME = "Deuterium"
        val DESCRIPTION = "Deuterium is a stable isotopes of hydrogen"
        val COLOR = 0xff5555
    }

    override fun getBucket(): Item {
        return ItemRegistry.DEUTERIUM_BUCKET
    }

    override fun createLegacyBlock(state: FluidState): BlockState {
        return with(FluidRegistry.DEUTERIUM_BLOCK!!.defaultBlockState()) {
            setValue(BlockStateProperties.LEVEL, getLegacyLevel(state))
        }
    }

    override fun getFlowing(): Fluid {
        return FluidRegistry.DEUTERIUM_FLOWING!!
    }

    override fun getSource(): Fluid {
        return FluidRegistry.DEUTERIUM_SOURCE!!
    }

    object Flowing : Deuterium() {
        override fun isSource(state: FluidState): Boolean {
            return false
        }

        override fun getAmount(state: FluidState): Int {
            return state.getValue(LEVEL)
        }

        override fun createFluidStateDefinition(
            builder: StateDefinition.Builder<Fluid, FluidState>
        ) {
            super.createFluidStateDefinition(builder)
            builder.add(LEVEL)
        }
    }

    object Source : Deuterium() {
        override fun isSource(state: FluidState): Boolean {
            return true
        }

        override fun getAmount(state: FluidState): Int {
            return 8
        }
    }
}
