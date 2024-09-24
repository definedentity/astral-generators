package dev.definedentity.astralgenerators.block.convergence_core

import dev.definedentity.astralgenerators.AstralGenerators
import mod.azure.azurelib.model.DefaultedBlockGeoModel
import mod.azure.azurelib.renderer.GeoBlockRenderer
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider
import net.minecraft.resources.ResourceLocation

class ConvergenceCoreRenderer(ctx: BlockEntityRendererProvider.Context) :
    GeoBlockRenderer<ConvergenceCoreEntity>(
        DefaultedBlockGeoModel(ResourceLocation(AstralGenerators.MOD_ID, "convergence_core"))
    ) {}
