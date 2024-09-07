package dev.definedentity.astralgenerators.block.multiblock_projector

import dev.definedentity.astralgenerators.registry.BlockEntityRegistry
import net.minecraft.core.BlockPos
import net.minecraft.world.level.block.entity.BlockEntity
import net.minecraft.world.level.block.state.BlockState

class MultiBlockProjectorEntity(pos: BlockPos, blockState: BlockState) :
    BlockEntity(
        BlockEntityRegistry.MULTIBLOCK_PROJECTOR_ENTITY,
        pos,
        blockState,
    ) {}
