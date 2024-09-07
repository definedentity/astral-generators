package dev.definedentity.astralgenerators.fluid

import dev.definedentity.astralgenerators.registry.FluidRegistry
import dev.definedentity.astralgenerators.registry.ItemRegistry
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.block.state.StateDefinition
import net.minecraft.world.level.block.state.properties.BlockStateProperties
import net.minecraft.world.level.material.Fluid
import net.minecraft.world.level.material.FluidState

abstract class Steam : AGFluid() {
    companion object {
        val ID = "steam"
        val NAME = "Steam"
        val DESCRIPTION = "Steam is a substance containing water in the gas phase"
        val COLOR = 0xbdc3c7
    }

    override fun getBucket(): Item {
        return ItemRegistry.STEAM_BUCKET
    }

    override fun createLegacyBlock(state: FluidState): BlockState {
        return with(FluidRegistry.STEAM_BLOCK!!.defaultBlockState()) {
            setValue(BlockStateProperties.LEVEL, getLegacyLevel(state))
        }
    }

    override fun getFlowing(): Fluid {
        return FluidRegistry.STEAM_FLOWING!!
    }

    override fun getSource(): Fluid {
        return FluidRegistry.STEAM_SOURCE!!
    }

    object Flowing : Steam() {
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

    object Source : Steam() {
        override fun isSource(state: FluidState): Boolean {
            return true
        }

        override fun getAmount(state: FluidState): Int {
            return 8
        }
    }
}
