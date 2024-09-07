package dev.definedentity.astralgenerators.item

import dev.definedentity.astralgenerators.fluid.Deuterium
import dev.definedentity.astralgenerators.registry.FluidRegistry
import net.minecraft.ChatFormatting
import net.minecraft.network.chat.Component
import net.minecraft.network.chat.TranslatableComponent
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.TooltipFlag
import net.minecraft.world.level.Level

class DeuteriumBucket() : AGBucketItem(FluidRegistry.DEUTERIUM_SOURCE!!, Deuterium.COLOR) {
    companion object {
        val ID = "deuterium_bucket"
        val NAME = "Deuterium Bucket"
        val TOOLTIP_CONTENT = Deuterium.DESCRIPTION
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
