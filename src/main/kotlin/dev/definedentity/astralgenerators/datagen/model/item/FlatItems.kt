package dev.definedentity.astralgenerators.datagen.model.item

import dev.definedentity.astralgenerators.registry.ItemRegistry
import net.minecraft.data.models.ItemModelGenerators
import net.minecraft.data.models.model.ModelTemplates
import net.minecraft.world.item.Item

class FlatItems(itemModelGenerator: ItemModelGenerators) {
    init {
        val items = listOf<Item>(ItemRegistry.TURBINE_ROTOR_BLADE)

        items.forEach { item ->
            itemModelGenerator.generateFlatItem(item, ModelTemplates.FLAT_ITEM)
        }
    }
}