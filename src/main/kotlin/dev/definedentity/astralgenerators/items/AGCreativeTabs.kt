package dev.definedentity.astralgenerators.items

import dev.definedentity.astralgenerators.AstralGenerators
import dev.definedentity.astralgenerators.AstralGenerators.Companion.REGISTRATE
import dev.definedentity.astralgenerators.utils.AGIdentifier
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder

object AGCreativeTabs {
    val GENERAL =
        FabricItemGroupBuilder.build(
            AGIdentifier("general"),
            { AGItems.JARVIS.get().defaultInstance }
        )

    fun register() {
        REGISTRATE.creativeModeTab({ AGCreativeTabs.GENERAL })
        REGISTRATE.addRawLang(GENERAL.displayName.string, AstralGenerators.MOD_NAME)
    }
}
