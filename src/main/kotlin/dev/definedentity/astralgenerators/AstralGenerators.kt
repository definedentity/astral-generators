package dev.definedentity.astralgenerators

import dev.definedentity.astralgenerators.multiblock.MultiBlockManager
import dev.definedentity.astralgenerators.registry.BlockEntityRegistry
import dev.definedentity.astralgenerators.registry.BlockRegistry
import dev.definedentity.astralgenerators.registry.FluidRegistry
import dev.definedentity.astralgenerators.registry.ItemRegistry
import dev.definedentity.astralgenerators.util.TimeKeeper
import mod.azure.azurelib.AzureLib
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents
import net.minecraft.resources.ResourceLocation
import org.slf4j.LoggerFactory

class AstralGenerators : ModInitializer {
    companion object {
        val MOD_ID = "astralgenerators"
        val LOGGER = LoggerFactory.getLogger(MOD_ID)

        val ITEM_GROUP =
            FabricItemGroupBuilder.build(ResourceLocation(MOD_ID, "astral_generators")) {
                BlockRegistry.SUPERCONDUCTING_COIL.asItem().defaultInstance
            }
    }

    override fun onInitialize() {
        AzureLib.initialize()

        MultiBlockManager.init()
        FluidRegistry.init()
        BlockEntityRegistry.init()
        BlockRegistry.init()
        ItemRegistry.init()

        ServerTickEvents.END_SERVER_TICK.register { TimeKeeper.incrementServerTick() }
    }
}
