package dev.definedentity.astralgenerators.datagen.model

import dev.definedentity.astralgenerators.registry.ItemRegistry
import net.minecraft.data.models.ItemModelGenerators

class BucketModel(itemModelGenerator: ItemModelGenerators) {
    init {
        val buckets =
            listOf(
                ItemRegistry.DEUTERIUM_BUCKET,
                ItemRegistry.TRITIUM_BUCKET,
                ItemRegistry.HELIUM3_BUCKET
            )
        val upsideDownBuckets = listOf(ItemRegistry.STEAM_BUCKET)

        buckets.forEach { itemModelGenerator.generateFlatItem(it, AGModelTemplates.BUCKET) }
        upsideDownBuckets.forEach {
            itemModelGenerator.generateFlatItem(it, AGModelTemplates.UPSIDE_DOWN_BUCKET)
        }
    }
}
