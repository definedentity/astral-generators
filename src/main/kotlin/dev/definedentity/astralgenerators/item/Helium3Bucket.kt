package dev.definedentity.astralgenerators.item

import dev.definedentity.astralgenerators.fluid.Helium3
import dev.definedentity.astralgenerators.registry.FluidRegistry
import net.minecraft.ChatFormatting
import net.minecraft.network.chat.Component
import net.minecraft.network.chat.TranslatableComponent
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.TooltipFlag
import net.minecraft.world.level.Level

class Helium3Bucket() : AGBucketItem(FluidRegistry.HELIUM3_SOURCE!!, Helium3.COLOR) {
    companion object {
        val ID = "helium3_bucket"
        val NAME = "Helium3 Bucket"
        val DESCRIPTION = Helium3.DESCRIPTION
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
