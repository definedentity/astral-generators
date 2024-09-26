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
                ResourceLocation(AstralGenerators.MOD_ID, MultiBlockProjectorEntity.ID),
                FabricBlockEntityTypeBuilder.create(
                        ::MultiBlockProjectorEntity,
                        BlockRegistry.MULTIBLOCK_PROJECTOR
                    )
                    .build()
            )

        val CONVERGENCE_CORE_ENTITY =
            Registry.register(
                Registry.BLOCK_ENTITY_TYPE,
                ResourceLocation(AstralGenerators.MOD_ID, ConvergenceCoreEntity.ID),
                FabricBlockEntityTypeBuilder.create(
                        ::ConvergenceCoreEntity,
                        BlockRegistry.CONVERGENCE_CORE
                    )
                    .build()
            )

        fun init() {}
    }
}
