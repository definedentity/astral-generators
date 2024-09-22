package dev.definedentity.astralgenerators.multiblock

import net.minecraft.util.StringRepresentable

enum class MultiBlockType(private val multiblockName: String) : StringRepresentable {
    FUSION_REACTOR("fusion_reactor"),
    PARTICLE_ACCELERATOR("particle_accelerator"),
    STEAM_TURBINE("steam_turbine"),
    AMALGAMATION_MATRIX("amalgamation_matrix"),
    SOLID_BOILER("solid_boiler"),
    FLUID_BOILER("fluid_boiler");

    override fun getSerializedName(): String {
        return multiblockName
    }
}
