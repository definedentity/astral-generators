package dev.definedentity.astralgenerators.datagen.model.block

import dev.definedentity.astralgenerators.registry.BlockRegistry
import net.minecraft.data.models.BlockModelGenerators
import net.minecraft.world.level.block.Block

class TrivialCube(blockStateModelGenerator: BlockModelGenerators) {
    init {
        val blocks =
            listOf<Block>(
                BlockRegistry.FUSION_CASING,
                BlockRegistry.FUSION_GLASS,
                // BlockRegistry.STRUCTURAL_GLASS,
                BlockRegistry.FUSION_COIL,
                BlockRegistry.ENGINE_INTAKE_CASING,
                BlockRegistry.PIPE_CASING,
                BlockRegistry.STEEL_FRAME,
                BlockRegistry.SUPERCONDUCTING_COIL,
                BlockRegistry.VENT,
                BlockRegistry.AMALGAMATION_MATRIX_CONTROLLER,
                BlockRegistry.CONVERGENCE_CORE
            )

        blocks.forEach { blockStateModelGenerator.createTrivialCube(it) }
    }
}
