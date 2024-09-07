package dev.definedentity.astralgenerators.datagen

import dev.definedentity.astralgenerators.datagen.lang.EnglishLangProvider
import dev.definedentity.astralgenerators.datagen.model.ModelProvider
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator

object AGDataGen : DataGeneratorEntrypoint {
    override fun onInitializeDataGenerator(fabricDataGenerator: FabricDataGenerator) {
        fabricDataGenerator.addProvider(ModelProvider(fabricDataGenerator))
        fabricDataGenerator.addProvider(EnglishLangProvider(fabricDataGenerator))
    }
}
