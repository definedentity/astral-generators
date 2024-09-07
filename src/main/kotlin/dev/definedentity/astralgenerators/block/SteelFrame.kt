package dev.definedentity.astralgenerators.block

import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.world.level.block.Blocks

class SteelFrame : AGBlock(FabricBlockSettings.copy(Blocks.IRON_BARS).noOcclusion()) {
    companion object {
        val ID = "steel_frame"
        val NAME = "Steel Frame"
        val TOOLTIP_CONTENT = "A frame made of steel."
    }

    override fun getTooltipContent(): String {
        return TOOLTIP_CONTENT
    }

    override fun getBlockId(): String {
        return ID
    }
}
