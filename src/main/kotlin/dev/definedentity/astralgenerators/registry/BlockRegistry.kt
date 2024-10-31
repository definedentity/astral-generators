package dev.definedentity.astralgenerators.registry

import com.tterrag.registrate.util.entry.BlockEntry
import dev.definedentity.astralgenerators.AstralGenerators.Companion.REGISTRATE
import dev.definedentity.astralgenerators.utils.TextFormatting
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.state.BlockBehaviour
import net.minecraft.world.level.material.Material

object BlockRegistry {
    /** Register non occlusion metal block with default block item model */
    fun <T : Block> nonOcclusionBlock(
        name: String,
        blockSupplier: (BlockBehaviour.Properties) -> T
    ): BlockEntry<T> {
        return REGISTRATE.block(name, blockSupplier)
            .lang(TextFormatting.toEnglishName(name))
            .simpleItem()
            .properties { BlockBehaviour.Properties.of(Material.METAL).noOcclusion() }
            .register()
    }

    /** Register glass block with default block item model */
    fun <T : Block> glassBlock(
        name: String,
        blockSupplier: (BlockBehaviour.Properties) -> T
    ): BlockEntry<T> {
        return REGISTRATE.block(name, blockSupplier)
            .lang(TextFormatting.toEnglishName(name))
            .simpleItem()
            .properties({ BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion() })
            .register()
    }

    /** Register item with default block item model and custom name */
    fun <T : Block> block(
        name: String,
        englishName: String,
        blockSupplier: (BlockBehaviour.Properties) -> T
    ): BlockEntry<T> {
        return REGISTRATE.block(name, blockSupplier).lang(englishName).simpleItem().register()
    }

    /** Register item with default block item model */
    fun <T : Block> block(
        name: String,
        blockSupplier: (BlockBehaviour.Properties) -> T
    ): BlockEntry<T> {
        return REGISTRATE.block(name, blockSupplier)
            .lang(TextFormatting.toEnglishName(name))
            .simpleItem()
            .register()
    }
}
