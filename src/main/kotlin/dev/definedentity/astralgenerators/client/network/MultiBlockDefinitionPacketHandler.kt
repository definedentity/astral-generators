package dev.definedentity.astralgenerators.client.network

import com.google.gson.JsonParser
import dev.definedentity.astralgenerators.multiblock.MultiBlockDefinition
import dev.definedentity.astralgenerators.multiblock.MultiBlockManager
import dev.definedentity.astralgenerators.network.ChannelList
import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking
import net.minecraft.resources.ResourceLocation

@Environment(EnvType.CLIENT)
class MultiBlockDefinitionPacketHandler {
    companion object {
        init {
            ClientPlayNetworking.registerGlobalReceiver(ChannelList.MULTIBLOCK_CHANNEL) {
                client,
                _,
                buf,
                _ ->
                val count = buf.readVarInt()
                val multiBlockMap = hashMapOf<ResourceLocation, MultiBlockDefinition>()

                for (i in 0 until count) {
                    val id = buf.readResourceLocation()
                    val json = buf.readUtf()
                    multiBlockMap[id] = MultiBlockDefinition(id, JsonParser.parseString(json))
                }

                client.execute {
                    multiBlockMap.forEach { (key, value) ->
                        MultiBlockManager.LOCAL_DEFINITIONS[key] = value
                    }
                }
            }
        }
    }
}
