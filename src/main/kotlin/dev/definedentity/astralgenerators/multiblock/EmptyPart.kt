package dev.definedentity.astralgenerators.multiblock

import java.util.Collections
import net.minecraft.core.BlockPos
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks

class EmptyPart : MultiBlockPart {
    override fun isMatch(level: Level, pos: BlockPos): Boolean {
        return level.isEmptyBlock(pos)
    }

    override fun validBlocks(): Collection<Block> {
        return Collections.singleton(Blocks.AIR)
    }
}
