package dev.definedentity.astralgenerators.datagen

import dev.definedentity.astralgenerators.AstralGenerators
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.minecraftforge.common.data.ExistingFileHelper

object AGDataGen : DataGeneratorEntrypoint {
    override fun onInitializeDataGenerator(fabricDataGenerator: FabricDataGenerator) {
        val helper = ExistingFileHelper.withResourcesFromArg()

        AstralGenerators.REGISTRATE.setupDatagen(fabricDataGenerator, helper)
    }
}
