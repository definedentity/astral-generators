package dev.definedentity.astralgenerators.client.renderer

import dev.definedentity.astralgenerators.block.multiblock_projector.MultiBlockProjectorRenderer
import dev.definedentity.astralgenerators.registry.BlockEntityRegistry
import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry

@Environment(EnvType.CLIENT)
class BlockEntityRenderer {
    init {
        BlockEntityRendererRegistry.register(
            BlockEntityRegistry.MULTIBLOCK_PROJECTOR_ENTITY,
            ::MultiBlockProjectorRenderer
        )
    }
}
