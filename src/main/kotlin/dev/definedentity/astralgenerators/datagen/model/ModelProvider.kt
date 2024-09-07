package dev.definedentity.astralgenerators.datagen.model

import dev.definedentity.astralgenerators.datagen.model.block.TrivialCube
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider
import net.minecraft.data.models.BlockModelGenerators
import net.minecraft.data.models.ItemModelGenerators

class ModelProvider(dataGenerator: FabricDataGenerator) : FabricModelProvider(dataGenerator) {
    override fun generateBlockStateModels(blockStateModelGenerator: BlockModelGenerators) {
        TrivialCube(blockStateModelGenerator)
    }

    override fun generateItemModels(itemModelGenerator: ItemModelGenerators) {
        BucketModel(itemModelGenerator)
    }
}
