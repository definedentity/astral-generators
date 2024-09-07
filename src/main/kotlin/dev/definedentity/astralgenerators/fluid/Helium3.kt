package dev.definedentity.astralgenerators.fluid

import dev.definedentity.astralgenerators.registry.FluidRegistry
import dev.definedentity.astralgenerators.registry.ItemRegistry
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.block.state.StateDefinition
import net.minecraft.world.level.block.state.properties.BlockStateProperties
import net.minecraft.world.level.material.Fluid
import net.minecraft.world.level.material.FluidState

abstract class Helium3 : AGFluid() {
    companion object {
        val ID = "helium3"
        val NAME = "Helium3"
        val DESCRIPTION =
            "Helium-3 is a light, stable isotope of helium with two protons and one neutron"
        val COLOR = 0xf1fa8c
    }

    override fun getBucket(): Item {
        return ItemRegistry.HELIUM3_BUCKET
    }

    override fun createLegacyBlock(state: FluidState): BlockState {
        return with(FluidRegistry.HELIUM3_BLOCK!!.defaultBlockState()) {
            setValue(BlockStateProperties.LEVEL, getLegacyLevel(state))
        }
    }

    override fun getFlowing(): Fluid {
        return FluidRegistry.HELIUM3_FLOWING!!
    }

    override fun getSource(): Fluid {
        return FluidRegistry.HELIUM3_SOURCE!!
    }

    object Flowing : Helium3() {
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

    object Source : Helium3() {
        override fun isSource(state: FluidState): Boolean {
            return true
        }

        override fun getAmount(state: FluidState): Int {
            return 8
        }
    }
}
