package dev.definedentity.astralgenerators.multiblock

import com.google.common.collect.Lists
import net.minecraft.core.BlockPos
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks

interface MultiBlockPart {
    fun isMatch(level: Level, pos: BlockPos): Boolean

    fun validBlocks(): Collection<Block>

    val firstValidBlock: Block
        get() {
            val list: List<Block> = Lists.newArrayList(validBlocks())
            return if (list.isEmpty()) Blocks.AIR else list[0]
        }
}
