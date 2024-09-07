package dev.definedentity.astralgenerators.block

import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.world.level.block.Blocks

class StructuralGlass : AGGlassBlock(FabricBlockSettings.copy(Blocks.GLASS).noOcclusion()) {
    companion object {
        val ID = "structural_glass"
        val NAME = "Structural Glass"
        val TOOLTIP_CONTENT = "A glass block which is used for building most multiblocks."
    }

    override fun getTooltipContent(): String {
        return TOOLTIP_CONTENT
    }

    override fun getBlockId(): String {
        return ID
    }
}
