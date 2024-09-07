package dev.definedentity.astralgenerators.multiblock

import java.util.Collections
import net.minecraft.core.BlockPos
import net.minecraft.core.Registry
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.Block

class BlockPart(private val id: ResourceLocation) : MultiBlockPart {
    var block: Block? = null

    init {
        block = Registry.BLOCK.get(id)
    }

    override fun isMatch(level: Level, pos: BlockPos): Boolean {
        val state = level.getBlockState(pos)

        if (state.block is StructurePart) {
            return (state.block as StructurePart).`is`(level, pos, block!!)
        }

        return state.`is`(block!!)
    }

    override fun validBlocks(): Collection<Block> {
        return Collections.singleton(block!!)
    }
}
