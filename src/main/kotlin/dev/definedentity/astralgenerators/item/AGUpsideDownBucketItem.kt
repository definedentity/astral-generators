package dev.definedentity.astralgenerators.item

import dev.definedentity.astralgenerators.AstralGenerators
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.world.item.BucketItem
import net.minecraft.world.level.material.FlowingFluid

abstract class AGUpsideDownBucketItem(fluid: FlowingFluid, private val fluidColor: Int) :
    BucketItem(fluid, FabricItemSettings().maxCount(1).group(AstralGenerators.ITEM_GROUP)) {
    fun getFluidColor(tintIndex: Int): Int {
        return if (tintIndex == 1) fluidColor else -1
    }
}
