package dev.definedentity.astralgenerators.items

import dev.definedentity.astralgenerators.AstralGenerators
import dev.definedentity.astralgenerators.registry.ItemRegistry

object AGItems {
    val JARVIS = ItemRegistry.item(Jarvis.ID, "J.A.R.V.I.S", ::Jarvis)
    val MULTI_BLOCK_ASSEMBLER = ItemRegistry.item(MultiBlockAssembler.ID, ::MultiBlockAssembler)

    fun register() {
        AstralGenerators.LOGGER.info("Registering items...")
    }
}
