package dev.definedentity.astralgenerators.fluid

import dev.definedentity.astralgenerators.registry.FluidRegistry
import dev.definedentity.astralgenerators.registry.ItemRegistry
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.block.state.StateDefinition
import net.minecraft.world.level.block.state.properties.BlockStateProperties
import net.minecraft.world.level.material.Fluid
import net.minecraft.world.level.material.FluidState

abstract class Tritium : AGFluid() {
    companion object {
        val ID = "tritium"
        val NAME = "Tritium"
        val DESCRIPTION = "Tritium is a rare and radioactive isotope of hydrogen"
        val COLOR = 0x50fa7b
    }

    override fun getBucket(): Item {
        return ItemRegistry.TRITIUM_BUCKET
    }

    override fun createLegacyBlock(state: FluidState): BlockState {
        return with(FluidRegistry.TRITIUM_BLOCK!!.defaultBlockState()) {
            setValue(BlockStateProperties.LEVEL, getLegacyLevel(state))
        }
    }

    override fun getFlowing(): Fluid {
        return FluidRegistry.TRITIUM_FLOWING!!
    }

    override fun getSource(): Fluid {
        return FluidRegistry.TRITIUM_SOURCE!!
    }

    object Flowing : Tritium() {
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

    object Source : Tritium() {
        override fun isSource(state: FluidState): Boolean {
            return true
        }

        override fun getAmount(state: FluidState): Int {
            return 8
        }
    }
}
