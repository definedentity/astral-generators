package dev.definedentity.astralgenerators.blocks

import dev.definedentity.astralgenerators.AstralGenerators
import dev.definedentity.astralgenerators.registry.BlockRegistry

object AGBlocks {

    val STEEL_PIPE_CASING = BlockRegistry.block(SteelPipeCasing.ID, ::SteelPipeCasing)
    val CONVERGENCE_CORE = BlockRegistry.block(ConvergenceCore.ID, ::ConvergenceCore)
    val ENGINE_INTAKE_CASING = BlockRegistry.block(EngineIntakeCasing.ID, ::EngineIntakeCasing)
    val VENT = BlockRegistry.nonOcclusionBlock(Vent.ID, ::Vent)
    val FUSION_CASING = BlockRegistry.block(FusionCasing.ID, ::FusionCasing)
    val FUSION_GLASS = BlockRegistry.glassBlock(FusionGlass.ID, ::FusionGlass)
    val FUSION_COIL = BlockRegistry.block(FusionCoil.ID, ::FusionCoil)

    fun register() {
        AstralGenerators.LOGGER.info("Registering blocks...")
    }
}
