package dev.definedentity.astralgenerators.client.rendering

import dev.definedentity.astralgenerators.blocks.AGBlocks
import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap
import net.minecraft.client.renderer.RenderType

@Environment(EnvType.CLIENT)
object GlassBlockRendering {
    val blocks = listOf(AGBlocks.FUSION_GLASS.get())

    fun init() {
        blocks.forEach { BlockRenderLayerMap.INSTANCE.putBlock(it, RenderType.translucent()) }
    }
}
