package dev.definedentity.astralgenerators.registry

import dev.definedentity.astralgenerators.AstralGenerators
import dev.definedentity.astralgenerators.block.convergence_core.ConvergenceCoreEntity
import dev.definedentity.astralgenerators.block.multiblock_projector.MultiBlockProjectorEntity
import net.fabricmc.fabric.api.`object`.builder.v1.block.entity.FabricBlockEntityTypeBuilder
import net.minecraft.core.Registry
import net.minecraft.resources.ResourceLocation

class BlockEntityRegistry {
    companion object {
        val MULTIBLOCK_PROJECTOR_ENTITY =
            Registry.register(
                Registry.BLOCK_ENTITY_TYPE,
                ResourceLocation(AstralGenerators.MOD_ID, "multiblock_projector_entity"),
                FabricBlockEntityTypeBuilder.create(
                        ::MultiBlockProjectorEntity,
                        BlockRegistry.MULTIBLOK_PROJECTOR
                    )
                    .build()
            )

        val CONVERGENCE_CORE_ENTITY =
            Registry.register(
                Registry.BLOCK_ENTITY_TYPE,
                ResourceLocation(AstralGenerators.MOD_ID, "convergence_core_entity"),
                FabricBlockEntityTypeBuilder.create(
                        ::ConvergenceCoreEntity,
                        BlockRegistry.CONVERGENCE_CORE
                    )
                    .build()
            )

        fun init() {}
    }
}
