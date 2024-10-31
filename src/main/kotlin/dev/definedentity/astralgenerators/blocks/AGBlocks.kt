package dev.definedentity.astralgenerators.blocks

import dev.definedentity.astralgenerators.AstralGenerators
import dev.definedentity.astralgenerators.registry.BlockRegistry
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.GlassBlock

object AGBlocks {

    val STEEL_PIPE_CASING = BlockRegistry.block("steel_pipe_casing", ::Block)

    val FUSION_CASING = BlockRegistry.block("fusion_casing", ::Block)
    val FUSION_GLASS = BlockRegistry.glassBlock("fusion_glass", ::GlassBlock)
    val FUSION_COIL = BlockRegistry.block("fusion_coil", ::Block)

    fun register() {
        AstralGenerators.LOGGER.info("Registering blocks...")
    }
}
