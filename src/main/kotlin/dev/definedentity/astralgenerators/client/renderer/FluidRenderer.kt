package dev.definedentity.astralgenerators.client.renderer

import dev.definedentity.astralgenerators.fluid.Deuterium
import dev.definedentity.astralgenerators.fluid.Helium3
import dev.definedentity.astralgenerators.fluid.Tritium
import dev.definedentity.astralgenerators.registry.FluidRegistry
import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler

@Environment(EnvType.CLIENT)
class FluidRenderer {
    init {
        FluidRenderHandlerRegistry.INSTANCE.register(
            FluidRegistry.STEAM_SOURCE!!,
            SimpleFluidRenderHandler(
                SimpleFluidRenderHandler.WATER_STILL,
                SimpleFluidRenderHandler.WATER_FLOWING,
                0xbdc3c7
            )
        )
        FluidRenderHandlerRegistry.INSTANCE.register(
            FluidRegistry.STEAM_FLOWING!!,
            SimpleFluidRenderHandler(
                SimpleFluidRenderHandler.WATER_STILL,
                SimpleFluidRenderHandler.WATER_FLOWING,
                0xbdc3c7
            )
        )

        FluidRenderHandlerRegistry.INSTANCE.register(
            FluidRegistry.DEUTERIUM_SOURCE!!,
            SimpleFluidRenderHandler(
                SimpleFluidRenderHandler.WATER_STILL,
                SimpleFluidRenderHandler.WATER_FLOWING,
                Deuterium.COLOR
            )
        )
        FluidRenderHandlerRegistry.INSTANCE.register(
            FluidRegistry.DEUTERIUM_FLOWING!!,
            SimpleFluidRenderHandler(
                SimpleFluidRenderHandler.WATER_STILL,
                SimpleFluidRenderHandler.WATER_FLOWING,
                Deuterium.COLOR
            )
        )

        FluidRenderHandlerRegistry.INSTANCE.register(
            FluidRegistry.TRITIUM_SOURCE!!,
            SimpleFluidRenderHandler(
                SimpleFluidRenderHandler.WATER_STILL,
                SimpleFluidRenderHandler.WATER_FLOWING,
                Tritium.COLOR
            )
        )
        FluidRenderHandlerRegistry.INSTANCE.register(
            FluidRegistry.TRITIUM_FLOWING!!,
            SimpleFluidRenderHandler(
                SimpleFluidRenderHandler.WATER_STILL,
                SimpleFluidRenderHandler.WATER_FLOWING,
                Tritium.COLOR
            )
        )

        FluidRenderHandlerRegistry.INSTANCE.register(
            FluidRegistry.HELIUM3_SOURCE!!,
            SimpleFluidRenderHandler(
                SimpleFluidRenderHandler.WATER_STILL,
                SimpleFluidRenderHandler.WATER_FLOWING,
                Helium3.COLOR
            )
        )
        FluidRenderHandlerRegistry.INSTANCE.register(
            FluidRegistry.HELIUM3_FLOWING!!,
            SimpleFluidRenderHandler(
                SimpleFluidRenderHandler.WATER_STILL,
                SimpleFluidRenderHandler.WATER_FLOWING,
                Helium3.COLOR
            )
        )
    }
}
