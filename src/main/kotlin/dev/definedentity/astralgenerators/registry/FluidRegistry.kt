package dev.definedentity.astralgenerators.registry

import dev.definedentity.astralgenerators.AstralGenerators
import dev.definedentity.astralgenerators.fluid.Deuterium
import dev.definedentity.astralgenerators.fluid.Helium3
import dev.definedentity.astralgenerators.fluid.Steam
import dev.definedentity.astralgenerators.fluid.Tritium
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.core.Registry
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.LiquidBlock
import net.minecraft.world.level.material.FlowingFluid

class FluidRegistry {
    companion object {
        var STEAM_SOURCE: FlowingFluid? = null
        var STEAM_FLOWING: FlowingFluid? = null
        var STEAM_BLOCK: Block? = null

        var DEUTERIUM_SOURCE: FlowingFluid? = null
        var DEUTERIUM_FLOWING: FlowingFluid? = null
        var DEUTERIUM_BLOCK: Block? = null

        var TRITIUM_SOURCE: FlowingFluid? = null
        var TRITIUM_FLOWING: FlowingFluid? = null
        var TRITIUM_BLOCK: Block? = null

        var HELIUM3_SOURCE: FlowingFluid? = null
        var HELIUM3_FLOWING: FlowingFluid? = null
        var HELIUM3_BLOCK: Block? = null

        fun init() {
            // Steam
            STEAM_SOURCE =
                Registry.register(
                    Registry.FLUID,
                    ResourceLocation(AstralGenerators.MOD_ID, "steam"),
                    Steam.Source
                )
            STEAM_FLOWING =
                Registry.register(
                    Registry.FLUID,
                    ResourceLocation(AstralGenerators.MOD_ID, "steam_flowing"),
                    Steam.Flowing
                )
            STEAM_BLOCK =
                registerFluidBlock(
                    Steam.ID,
                    LiquidBlock(
                        STEAM_SOURCE!!,
                        FabricBlockSettings.copy(Blocks.WATER).strength(100f).noDrops()
                    )
                )
            // Deuterium
            DEUTERIUM_SOURCE =
                Registry.register(
                    Registry.FLUID,
                    ResourceLocation(AstralGenerators.MOD_ID, "deuterium"),
                    Deuterium.Source
                )
            DEUTERIUM_FLOWING =
                Registry.register(
                    Registry.FLUID,
                    ResourceLocation(AstralGenerators.MOD_ID, "deuterium_flowing"),
                    Deuterium.Flowing
                )
            DEUTERIUM_BLOCK =
                registerFluidBlock(
                    Deuterium.ID,
                    LiquidBlock(
                        DEUTERIUM_SOURCE!!,
                        FabricBlockSettings.copy(Blocks.WATER).strength(100f).noDrops()
                    )
                )
            // Tritium
            TRITIUM_SOURCE =
                Registry.register(
                    Registry.FLUID,
                    ResourceLocation(AstralGenerators.MOD_ID, "tritium"),
                    Tritium.Source
                )
            TRITIUM_FLOWING =
                Registry.register(
                    Registry.FLUID,
                    ResourceLocation(AstralGenerators.MOD_ID, "tritium_flowing"),
                    Tritium.Flowing
                )
            TRITIUM_BLOCK =
                registerFluidBlock(
                    Tritium.ID,
                    LiquidBlock(
                        TRITIUM_SOURCE!!,
                        FabricBlockSettings.copy(Blocks.WATER).strength(100f).noDrops()
                    )
                )
            // Helium3
            HELIUM3_SOURCE =
                Registry.register(
                    Registry.FLUID,
                    ResourceLocation(AstralGenerators.MOD_ID, "helium3"),
                    Helium3.Source
                )
            HELIUM3_FLOWING =
                Registry.register(
                    Registry.FLUID,
                    ResourceLocation(AstralGenerators.MOD_ID, "helium3_flowing"),
                    Helium3.Flowing
                )
            HELIUM3_BLOCK =
                registerFluidBlock(
                    Helium3.ID,
                    LiquidBlock(
                        HELIUM3_SOURCE!!,
                        FabricBlockSettings.copy(Blocks.WATER).strength(100f).noDrops()
                    )
                )
        }

        private fun registerFluidBlock(name: String, block: Block): Block {
            return Registry.register(
                Registry.BLOCK,
                ResourceLocation(AstralGenerators.MOD_ID, name),
                block
            )
        }
    }
}
