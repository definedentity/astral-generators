package dev.definedentity.astralgenerators

import com.tterrag.registrate.Registrate
import dev.definedentity.astralgenerators.blocks.AGBlocks
import dev.definedentity.astralgenerators.items.AGCreativeTabs
import dev.definedentity.astralgenerators.items.AGItems
import dev.definedentity.astralgenerators.material_sets.CasingSets
import dev.definedentity.astralgenerators.material_sets.CoilSets
import dev.definedentity.astralgenerators.material_sets.MaterialSets
import net.fabricmc.api.ModInitializer
import org.slf4j.LoggerFactory

class AstralGenerators : ModInitializer {
    companion object {
        val MOD_ID = "astralgenerators"
        val MOD_NAME = "Astral Generators"
        val LOGGER = LoggerFactory.getLogger(MOD_NAME)

        val REGISTRATE = Registrate.create(MOD_ID)
    }

    override fun onInitialize() {
        AGCreativeTabs.register()

        MaterialSets.register()
        CasingSets.register()
        CoilSets.register()

        AGItems.register()
        AGBlocks.register()
        REGISTRATE.register()
    }
}
