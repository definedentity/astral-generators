package dev.definedentity.astralgenerators.block.convergence_core

import dev.definedentity.astralgenerators.AstralGenerators
import mod.azure.azurelib.model.DefaultedBlockGeoModel
import mod.azure.azurelib.renderer.GeoItemRenderer
import net.minecraft.resources.ResourceLocation

class ConvergenceCoreItemRenderer :
    GeoItemRenderer<ConvergenceCoreItem>(
        DefaultedBlockGeoModel(ResourceLocation(AstralGenerators.MOD_ID, "convergence_core"))
    ) {}
