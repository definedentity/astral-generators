package dev.definedentity.astralgenerators.block

import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.core.BlockPos
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.RenderShape
import net.minecraft.world.level.block.entity.BlockEntity
import net.minecraft.world.level.block.state.BlockState

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
