package dev.definedentity.astralgenerators.client

import dev.definedentity.astralgenerators.client.network.MultiBlockDefinitionPacketHandler
import dev.definedentity.astralgenerators.client.renderer.BlockEntityRenderer
import dev.definedentity.astralgenerators.client.renderer.BlockRenderer
import dev.definedentity.astralgenerators.client.renderer.BucketRenderer
import dev.definedentity.astralgenerators.client.renderer.FluidRenderer
import dev.definedentity.astralgenerators.util.TimeKeeper
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents

@Environment(EnvType.CLIENT)
class AGClient : ClientModInitializer {
    override fun onInitializeClient() {
        BlockRenderer()
        BlockEntityRenderer()
        FluidRenderer()
        BucketRenderer()
        MultiBlockDefinitionPacketHandler()

        ClientTickEvents.END_CLIENT_TICK.register{TimeKeeper.incrementClientTick()}
    }
}
