package dev.definedentity.astralgenerators.block

import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.world.level.block.Blocks

class FusionGlass : AGGlassBlock(FabricBlockSettings.copy(Blocks.GLASS).noOcclusion()) {
    companion object {
        const val ID = "fusion_glass"
        const val NAME = "Fusion Glass"
        const val TOOLTIP_CONTENT = "A glass for the fusion reactor."
    }

    override fun getTooltipContent(): String {
        return TOOLTIP_CONTENT
    }

    override fun getBlockId(): String {
        return ID
    }
}
