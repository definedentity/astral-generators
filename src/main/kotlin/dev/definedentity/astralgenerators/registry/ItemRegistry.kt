package dev.definedentity.astralgenerators.registry

import dev.definedentity.astralgenerators.AstralGenerators
import dev.definedentity.astralgenerators.item.*
import net.minecraft.core.Registry
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.Item

class ItemRegistry {
    companion object {

        val STEAM_BUCKET = register(SteamBucket.ID, SteamBucket())
        val TRITIUM_BUCKET = register(TritiumBucket.ID, TritiumBucket())
        val DEUTERIUM_BUCKET = register(DeuteriumBucket.ID, DeuteriumBucket())
        val HELIUM3_BUCKET = register(Helium3Bucket.ID, Helium3Bucket())

        private fun register(name: String, item: Item): Item {
            return Registry.register(
                Registry.ITEM,
                ResourceLocation(AstralGenerators.MOD_ID, name),
                item
            )
        }

        fun init() {}
    }
}
