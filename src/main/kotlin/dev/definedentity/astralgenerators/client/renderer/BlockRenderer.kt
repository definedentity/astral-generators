package dev.definedentity.astralgenerators.client.renderer

import dev.definedentity.astralgenerators.registry.BlockRegistry
import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap
import net.minecraft.client.renderer.RenderType

@Environment(EnvType.CLIENT)
class BlockRenderer {
    init {
        renderTranslucentBlock()
    }

    private fun renderTranslucentBlock() {
        val block =
            listOf(
                BlockRegistry.FUSION_GLASS,
                BlockRegistry.STEEL_FRAME,
                BlockRegistry.VENT
                // BlockRegistry.STRUCTURAL_GLASS
            )

        block.forEach { BlockRenderLayerMap.INSTANCE.putBlock(it, RenderType.translucent()) }
    }
}
