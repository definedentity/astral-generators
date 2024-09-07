package dev.definedentity.astralgenerators.datagen.model

import dev.definedentity.astralgenerators.AstralGenerators
import java.util.*
import net.minecraft.data.models.model.ModelTemplate
import net.minecraft.resources.ResourceLocation

class AGModelTemplates {
    companion object {
        val UPSIDE_DOWN_BUCKET =
            ModelTemplate(
                Optional.of(ResourceLocation(AstralGenerators.MOD_ID, "item/upside_down_bucket")),
                Optional.empty()
            )
        val BUCKET =
            ModelTemplate(
                Optional.of(ResourceLocation(AstralGenerators.MOD_ID, "item/bucket")),
                Optional.empty()
            )
    }
}
