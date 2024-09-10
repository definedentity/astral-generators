package dev.definedentity.astralgenerators.datagen.lang

import dev.definedentity.astralgenerators.AstralGenerators
import dev.definedentity.astralgenerators.block.*
import dev.definedentity.astralgenerators.block.EngineIntakeCasing
import dev.definedentity.astralgenerators.block.machines.FluidBoiler
import dev.definedentity.astralgenerators.block.machines.SolidBoiler
import dev.definedentity.astralgenerators.block.machines.SteamTurbine
import dev.definedentity.astralgenerators.block.multiblock_projector.MultiBlockProjector
import dev.definedentity.astralgenerators.item.DeuteriumBucket
import dev.definedentity.astralgenerators.item.Helium3Bucket
import dev.definedentity.astralgenerators.item.SteamBucket
import dev.definedentity.astralgenerators.item.TritiumBucket
import dev.definedentity.astralgenerators.registry.BlockRegistry
import dev.definedentity.astralgenerators.registry.ItemRegistry
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider
import net.minecraft.world.item.Item

class EnglishLangProvider(fabricDataGenerator: FabricDataGenerator) :
    FabricLanguageProvider(fabricDataGenerator, "en_us") {
    override fun generateTranslations(translationBuilder: TranslationBuilder) {
        translationBuilder.add(
            "itemGroup.${AstralGenerators.MOD_ID}.astral_generators",
            "Astral Generators"
        )
        generateItemTranslations(translationBuilder)
        generateTooltipTranslations(translationBuilder)
        generateTextTranslations(translationBuilder)
    }

    private fun generateTextTranslations(translationBuilder: TranslationBuilder) {
        val texts = hashMapOf<String, String>()

        texts[MultiBlockProjector.ENABLE_MESSAGE_KEY] = MultiBlockProjector.ENABLE_MESSAGE
        texts[MultiBlockProjector.DISABLE_MESSAGE_KEY] = MultiBlockProjector.DISABLE_MESSAGE

        texts.forEach { (k, v) -> translationBuilder.add(k, v) }
    }

    private fun generateItemTranslations(translationBuilder: TranslationBuilder) {
        val items = hashMapOf<Item, String>()

        items[BlockRegistry.FUSION_CASING.asItem()] = FusionCasing.NAME
        items[BlockRegistry.FUSION_GLASS.asItem()] = FusionGlass.NAME
        items[BlockRegistry.STRUCTURAL_GLASS.asItem()] = StructuralGlass.NAME
        items[BlockRegistry.FUSION_COIL.asItem()] = FusionCoil.NAME
        items[BlockRegistry.ENGINE_INTAKE_CASING.asItem()] = EngineIntakeCasing.NAME
        items[BlockRegistry.PIPE_CASING.asItem()] = PipeCasing.NAME
        items[BlockRegistry.STEEL_FRAME.asItem()] = SteelFrame.NAME
        items[BlockRegistry.SUPERCONDUCTING_COIL.asItem()] = SuperconductingCoil.NAME
        items[BlockRegistry.VENT.asItem()] = Vent.NAME
        items[BlockRegistry.EXHAUST_VENT.asItem()] = ExhaustVent.NAME
        items[BlockRegistry.STAINLESS_STEEL_CASING.asItem()] = StainlessSteelCasing.NAME
        items[ItemRegistry.DEUTERIUM_BUCKET] = DeuteriumBucket.NAME
        items[ItemRegistry.HELIUM3_BUCKET] = Helium3Bucket.NAME
        items[ItemRegistry.TRITIUM_BUCKET] = TritiumBucket.NAME
        items[ItemRegistry.STEAM_BUCKET] = SteamBucket.NAME
        items[BlockRegistry.MULTIBLOK_PROJECTOR.asItem()] = MultiBlockProjector.NAME
        items[BlockRegistry.STEAM_TURBINE.asItem()] = SteamTurbine.NAME
        items[BlockRegistry.SOLID_BOILER.asItem()] = SolidBoiler.NAME
        items[BlockRegistry.FLUID_BOILER.asItem()] = FluidBoiler.NAME

        items.forEach { (k, v) -> translationBuilder.add(k, v) }
    }

    private fun generateTooltipTranslations(translationBuilder: TranslationBuilder) {
        val tooltips = hashMapOf<String, String>()

        tooltips[FusionCasing.ID] = FusionCasing.TOOLTIP_CONTENT
        tooltips[FusionGlass.ID] = FusionGlass.TOOLTIP_CONTENT
        tooltips[StructuralGlass.ID] = StructuralGlass.TOOLTIP_CONTENT
        tooltips[FusionCoil.ID] = FusionCoil.TOOLTIP_CONTENT
        tooltips[EngineIntakeCasing.ID] = EngineIntakeCasing.TOOLTIP_CONTENT
        tooltips[PipeCasing.ID] = PipeCasing.TOOLTIP_CONTENT
        tooltips[SteelFrame.ID] = SteelFrame.TOOLTIP_CONTENT
        tooltips[SuperconductingCoil.ID] = SuperconductingCoil.TOOLTIP_CONTENT
        tooltips[Vent.ID] = Vent.TOOLTIP_CONTENT
        tooltips[ExhaustVent.ID] = ExhaustVent.TOOLTIP_CONTENT
        tooltips[StainlessSteelCasing.ID] = StainlessSteelCasing.TOOLTIP_CONTENT
        tooltips[DeuteriumBucket.ID] = DeuteriumBucket.TOOLTIP_CONTENT
        tooltips[Helium3Bucket.ID] = Helium3Bucket.TOOLTIP_CONTENT
        tooltips[TritiumBucket.ID] = TritiumBucket.TOOLTIP_CONTENT
        tooltips[SteamBucket.ID] = SteamBucket.TOOLTIP_CONTENT
        tooltips[MultiBlockProjector.ID] = MultiBlockProjector.TOOLTIP_CONTENT
        tooltips[SteamTurbine.ID] = SteamTurbine.TOOLTIP_CONTENT
        tooltips[SolidBoiler.ID] = SolidBoiler.TOOLTIP_CONTENT
        tooltips[FluidBoiler.ID] = FluidBoiler.TOOLTIP_CONTENT

        tooltips.forEach { (k, v) -> translationBuilder.add("tooltip.${k}", v) }
    }
}
