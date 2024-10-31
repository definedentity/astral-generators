package dev.definedentity.astralgenerators.client

import dev.definedentity.astralgenerators.client.rendering.GlassBlockRendering
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment

@Environment(EnvType.CLIENT)
class AGClient : ClientModInitializer {
    override fun onInitializeClient() {
        GlassBlockRendering.init()
    }
}
