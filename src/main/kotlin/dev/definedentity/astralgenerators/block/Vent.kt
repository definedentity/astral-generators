package dev.definedentity.astralgenerators.block

import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.world.level.block.Blocks

class Vent : AGBlock(FabricBlockSettings.copy(Blocks.IRON_BARS).noOcclusion()) {
    companion object {
        val ID = "vent"
        val NAME = "Vent"
        val TOOLTIP_CONTENT = "A vent."
    }

    override fun getTooltipContent(): String {
        return TOOLTIP_CONTENT
    }

    override fun getBlockId(): String {
        return ID
    }
}
