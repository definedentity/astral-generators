package dev.definedentity.astralgenerators.item.turbine_rotor_blade

import dev.definedentity.astralgenerators.block.AGBlock
import dev.definedentity.astralgenerators.item.AGItem
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.world.level.material.Material

class TurbineRotorBlade: AGItem(FabricItemSettings()) {
    companion object {
        val ID = "turbine_rotor_blade"
        val NAME = "Turbine Rotor Blade"
        val TOOLTIP_CONTENT = "A blade for the turbine rotor"
    }
}