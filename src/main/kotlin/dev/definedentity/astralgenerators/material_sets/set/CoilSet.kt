package dev.definedentity.astralgenerators.material_sets.set

import dev.definedentity.astralgenerators.registry.BlockRegistry
import net.minecraft.world.level.block.Block

class CoilSet(name: String) {
    val COIL = BlockRegistry.block("${name}_coil", ::Block)
}
