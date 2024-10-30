package dev.definedentity.astralgenerators.items

import com.tterrag.registrate.util.entry.ItemEntry
import dev.definedentity.astralgenerators.AstralGenerators
import dev.definedentity.astralgenerators.utils.TextFormatting
import net.minecraft.world.item.Item

object AGItems {
    val JARVIS = item(Jarvis.ID, "J.A.R.V.I.S", ::Jarvis)
    val MULTI_BLOCK_ASSEMBLER = item(MultiBlockAssembler.ID, ::MultiBlockAssembler)

    /** Register item with default item model and custom name */
    fun <T : Item> item(
        name: String,
        englishName: String,
        itemSupplier: (Item.Properties) -> T
    ): ItemEntry<T> {
        return AstralGenerators.REGISTRATE.item(name, itemSupplier)
            .lang(englishName)
            .defaultModel()
            .register()
    }

    /** Register item with default item model */
    fun <T : Item> item(name: String, itemSupplier: (Item.Properties) -> T): ItemEntry<T> {
        return AstralGenerators.REGISTRATE.item(name, itemSupplier)
            .lang(TextFormatting.toEnglishName(name))
            .defaultModel()
            .register()
    }

    fun register() {
        AstralGenerators.LOGGER.info("Registering items...")
    }
}
