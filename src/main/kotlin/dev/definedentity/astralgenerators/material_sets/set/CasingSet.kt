package dev.definedentity.astralgenerators.material_sets.set

import com.tterrag.registrate.util.entry.BlockEntry
import dev.definedentity.astralgenerators.AstralGenerators.Companion.REGISTRATE
import dev.definedentity.astralgenerators.utils.TextFormatting
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.state.BlockBehaviour
import net.minecraft.world.level.material.Material

class CasingSet(name: String) {
    val CASING = machineCasingBlock("${name}_casing", ::Block)

    private fun <T : Block> machineCasingBlock(
        name: String,
        blockSupplier: (BlockBehaviour.Properties) -> T
    ): BlockEntry<T> {
        return REGISTRATE.block(name, blockSupplier)
            .lang(TextFormatting.toEnglishName(name))
            .simpleItem()
            .properties { BlockBehaviour.Properties.of(Material.METAL) }
            .register()
    }
}
