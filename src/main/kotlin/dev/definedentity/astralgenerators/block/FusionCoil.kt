package dev.definedentity.astralgenerators.block

import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.world.level.block.Blocks

class FusionCoil : AGBlock(FabricBlockSettings.copy(Blocks.IRON_BLOCK)) {
    companion object {
        val ID = "fusion_coil"
        val NAME = "Fusion Coil"
        val TOOLTIP_CONTENT = "A important component of the fusion reactor."
    }

    override fun getTooltipContent(): String {
        return TOOLTIP_CONTENT
    }

    override fun getBlockId(): String {
        return ID
    }
}
