package dev.definedentity.astralgenerators.items

import com.tterrag.registrate.util.entry.ItemEntry
import dev.definedentity.astralgenerators.AstralGenerators
import dev.definedentity.astralgenerators.utils.TextFormatting
import net.minecraft.world.item.Item

object AGItems {
    val JARVIS =
        AstralGenerators.REGISTRATE.item(Jarvis.ID, ::Jarvis)
            .lang("J.A.R.V.I.S")
            .defaultModel()
            .register()
    val MULTI_BLOCK_ASSEMBLER = item(MultiBlockAssembler.ID, ::MultiBlockAssembler)

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
