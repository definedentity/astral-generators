package dev.definedentity.astralgenerators.block.convergence_core

import dev.definedentity.astralgenerators.block.AGBaseEntityBlock
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.core.BlockPos
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.RenderShape
import net.minecraft.world.level.block.entity.BlockEntity
import net.minecraft.world.level.block.state.BlockState

class ConvergenceCore : AGBaseEntityBlock(FabricBlockSettings.copy(Blocks.LANTERN)) {
    companion object {
        val ID = "convergence_core"
        val NAME = "Convergence Core"
        val TOOLTIP_CONTENT = "Amalgamation Matrix core"
    }

    override fun getTooltipContent(): String {
        return TOOLTIP_CONTENT
    }

    override fun getBlockId(): String {
        return ID
    }

    override fun newBlockEntity(pos: BlockPos, state: BlockState): BlockEntity? {
        return ConvergenceCoreEntity(pos, state)
    }

    override fun getRenderShape(state: BlockState): RenderShape? {
        return RenderShape.ENTITYBLOCK_ANIMATED
    }
}
