package dev.definedentity.astralgenerators.item

import dev.definedentity.astralgenerators.fluid.Tritium
import dev.definedentity.astralgenerators.registry.FluidRegistry
import net.minecraft.ChatFormatting
import net.minecraft.network.chat.Component
import net.minecraft.network.chat.TranslatableComponent
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.TooltipFlag
import net.minecraft.world.level.Level

class TritiumBucket() : AGBucketItem(FluidRegistry.TRITIUM_SOURCE!!, Tritium.COLOR) {
    companion object {
        val ID = "tritium_bucket"
        val NAME = "Tritium Bucket"
        val DESCRIPTION = Tritium.DESCRIPTION
    }

    override fun appendHoverText(
        stack: ItemStack,
        world: Level?,
        tooltip: MutableList<Component>,
        context: TooltipFlag
    ) {
        tooltip.add(TranslatableComponent("tooltip.$ID").withStyle(ChatFormatting.GRAY))
    }
}
