package dev.definedentity.astralgenerators.block.turbine.turbine_rotor_shaft

import dev.definedentity.astralgenerators.block.AGBlock
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.core.BlockPos
import net.minecraft.world.level.BlockGetter
import net.minecraft.world.level.block.RenderShape
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.material.Material
import net.minecraft.world.phys.shapes.CollisionContext
import net.minecraft.world.phys.shapes.VoxelShape

class TurbineRotorShaft: AGBlock(FabricBlockSettings.of(Material.STONE).nonOpaque()) {
    companion object {
        val ID = "turbine_rotor_shaft"
        val NAME = "Turbine Rotor Shaft"
        val TOOLTIP_CONTENT = "A shaft for the turbine rotor"
    }

    override fun getBlockId(): String {
        return ID
    }

    override fun getTooltipContent(): String {
        return TOOLTIP_CONTENT
    }

    override fun getRenderShape(state: BlockState): RenderShape? {
        return RenderShape.MODEL
    }

    override fun getShape(
        state: BlockState,
        level: BlockGetter,
        pos: BlockPos,
        context: CollisionContext
    ): VoxelShape? {
        return box(6.0, 0.0, 6.0, 10.0, 16.0, 10.0)
    }
}