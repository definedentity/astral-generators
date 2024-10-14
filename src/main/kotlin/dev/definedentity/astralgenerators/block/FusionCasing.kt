package dev.definedentity.astralgenerators.block

import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.world.level.block.Blocks

class FusionCasing : AGBlock(FabricBlockSettings.copy(Blocks.IRON_BLOCK)) {
    companion object {
        const val ID = "fusion_casing"
        const val NAME = "Fusion Casing"
        const val TOOLTIP_CONTENT = "The main casing for the Fusion Reactor."
    }

    override fun getTooltipContent(): String {
        return TOOLTIP_CONTENT
    }

    override fun getBlockId(): String {
        return ID
    }
}
