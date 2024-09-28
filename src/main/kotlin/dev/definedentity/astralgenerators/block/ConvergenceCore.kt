package dev.definedentity.astralgenerators.block

import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.world.level.block.Blocks

class ConvergenceCore : AGBlock(FabricBlockSettings.copy(Blocks.LANTERN)) {
    companion object {
        val ID = "convergence_core"
        val NAME = "Convergence Core"
        val TOOLTIP_CONTENT = "Amalgamation Matrix Core"
    }

    override fun getTooltipContent(): String {
        return TOOLTIP_CONTENT
    }

    override fun getBlockId(): String {
        return ID
    }
}
