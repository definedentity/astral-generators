package dev.definedentity.astralgenerators.multiblock

import net.minecraft.util.StringRepresentable

enum class MultiBlockType(private val multiblockName: String) : StringRepresentable {
    FUSION_REACTOR("fusion_reactor"),
    PARTICLE_ACCELERATOR("particle_accelerator"),
    STEAM_TURBINE("steam_turbine"),
    AMALGAMATION_MATRIX("amalgamation_matrix");

    override fun getSerializedName(): String {
        return multiblockName
    }
}
