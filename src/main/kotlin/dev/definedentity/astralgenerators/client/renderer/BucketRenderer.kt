package dev.definedentity.astralgenerators.client.renderer

import dev.definedentity.astralgenerators.item.AGBucketItem
import dev.definedentity.astralgenerators.item.AGUpsideDownBucketItem
import dev.definedentity.astralgenerators.registry.ItemRegistry
import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry
import net.minecraft.client.color.item.ItemColor
import net.minecraft.world.item.ItemStack

@Environment(EnvType.CLIENT)
class BucketRenderer {
    init {
        val buckets =
            listOf(
                ItemRegistry.DEUTERIUM_BUCKET,
                ItemRegistry.TRITIUM_BUCKET,
                ItemRegistry.HELIUM3_BUCKET
            )
        val bucketsUpsideDown = listOf(ItemRegistry.STEAM_BUCKET)

        buckets.forEach {
            ColorProviderRegistry.ITEM.register(
                ItemColor { stack: ItemStack, tintIndex: Int ->
                    (stack.item as AGBucketItem).getFluidColor(tintIndex)
                },
                it
            )
        }
        bucketsUpsideDown.forEach {
            ColorProviderRegistry.ITEM.register(
                ItemColor { stack: ItemStack, tintIndex: Int ->
                    (stack.item as AGUpsideDownBucketItem).getFluidColor(tintIndex)
                },
                it
            )
        }
    }
}
