package dev.definedentity.astralgenerators.registry

import dev.definedentity.astralgenerators.AstralGenerators
import dev.definedentity.astralgenerators.block.*
import dev.definedentity.astralgenerators.block.EngineIntakeCasing
import dev.definedentity.astralgenerators.block.ConvergenceCore
import dev.definedentity.astralgenerators.block.machines.AmalgamationMatrixControllerDummy
import dev.definedentity.astralgenerators.block.machines.FluidBoiler
import dev.definedentity.astralgenerators.block.machines.SolidBoiler
import dev.definedentity.astralgenerators.block.machines.SteamTurbine
import dev.definedentity.astralgenerators.block.multiblock_projector.MultiBlockProjector
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.core.Registry
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.BlockItem
import net.minecraft.world.level.block.Block

class BlockRegistry {
    companion object {
        val FUSION_CASING = register(FusionCasing.ID, FusionCasing())
        val FUSION_GLASS = register(FusionGlass.ID, FusionGlass())
        val FUSION_COIL = register(FusionCoil.ID, FusionCoil())
        val ENGINE_INTAKE_CASING = register(EngineIntakeCasing.ID, EngineIntakeCasing())
        val PIPE_CASING = register(PipeCasing.ID, PipeCasing())
        val STEEL_FRAME = register(SteelFrame.ID, SteelFrame())
        val SUPERCONDUCTING_COIL = register(SuperconductingCoil.ID, SuperconductingCoil())
        val VENT = register(Vent.ID, Vent())

        val MULTIBLOCK_PROJECTOR = register(MultiBlockProjector.ID, MultiBlockProjector())
        val CONVERGENCE_CORE = register(ConvergenceCore.ID, ConvergenceCore())

        val AMALGAMATION_MATRIX_CONTROLLER =
            register(AmalgamationMatrixControllerDummy.ID, AmalgamationMatrixControllerDummy())
        val STEAM_TURBINE = register(SteamTurbine.ID, SteamTurbine())
        val SOLID_BOILER = register(SolidBoiler.ID, SolidBoiler())
        val FLUID_BOILER = register(FluidBoiler.ID, FluidBoiler())

        private fun register(name: String, block: Block): Block {
            registerSimpleBlockItem(name, block)
            return registerBlockOnly(name, block)
        }

        private fun registerSimpleBlockItem(name: String, block: Block): BlockItem {
            return Registry.register(
                Registry.ITEM,
                ResourceLocation(AstralGenerators.MOD_ID, name),
                BlockItem(block, FabricItemSettings().group(AstralGenerators.ITEM_GROUP))
            )
        }

        private fun registerBlockOnly(name: String, block: Block): Block {
            return Registry.register(
                Registry.BLOCK,
                ResourceLocation(AstralGenerators.MOD_ID, name),
                block
            )
        }

        fun init() {}
    }
}
