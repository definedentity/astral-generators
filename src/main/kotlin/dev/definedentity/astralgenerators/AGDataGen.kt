package dev.definedentity.astralgenerators

import dev.definedentity.astralgenerators.AstralGenerators.REGISTRATE
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.minecraftforge.common.data.ExistingFileHelper

object AGDataGen : DataGeneratorEntrypoint {
    override fun onInitializeDataGenerator(fabricDataGenerator: FabricDataGenerator) {
        val helper = ExistingFileHelper.withResourcesFromArg()

        REGISTRATE.setupDatagen(fabricDataGenerator, helper)
    }
}
