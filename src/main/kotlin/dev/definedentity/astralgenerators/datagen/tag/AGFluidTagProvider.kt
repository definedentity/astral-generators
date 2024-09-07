package dev.definedentity.astralgenerators.datagen.tag

import dev.definedentity.astralgenerators.registry.FluidRegistry
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider.FluidTagProvider
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.tags.TagKey
import net.minecraft.world.level.material.Fluid

class AGFluidTagProvider(dataGenerator: FabricDataGenerator) : FluidTagProvider(dataGenerator) {
    companion object {
        val STEAM_TAG: TagKey<Fluid> =
            TagKey.create<Fluid>(
                ResourceKey.createRegistryKey(ResourceLocation("c", "steam")),
                ResourceLocation("c", "steam")
            )
        val DEUTERIUM_TAG: TagKey<Fluid> =
            TagKey.create<Fluid>(
                ResourceKey.createRegistryKey(ResourceLocation("c", "deuterium")),
                ResourceLocation("c", "deuterium")
            )
        val TRITIUM_TAG: TagKey<Fluid> =
            TagKey.create<Fluid>(
                ResourceKey.createRegistryKey(ResourceLocation("c", "tritium")),
                ResourceLocation("c", "tritium")
            )
        val HELIUM3_TAG: TagKey<Fluid> =
            TagKey.create<Fluid>(
                ResourceKey.createRegistryKey(ResourceLocation("c", "helium3")),
                ResourceLocation("c", "helium3")
            )
    }

    override fun generateTags() {
        getOrCreateTagBuilder(STEAM_TAG).add(FluidRegistry.STEAM_SOURCE)
        getOrCreateTagBuilder(DEUTERIUM_TAG).add(FluidRegistry.DEUTERIUM_SOURCE)
        getOrCreateTagBuilder(TRITIUM_TAG).add(FluidRegistry.TRITIUM_SOURCE)
        getOrCreateTagBuilder(HELIUM3_TAG).add(FluidRegistry.HELIUM3_SOURCE)
    }

}