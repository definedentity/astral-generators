package dev.definedentity.astralgenerators.block

import net.minecraft.ChatFormatting
import net.minecraft.network.chat.Component
import net.minecraft.network.chat.TranslatableComponent
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.TooltipFlag
import net.minecraft.world.level.BlockGetter
import net.minecraft.world.level.block.Block

abstract class AGBlock(settings: Properties) : Block(settings) {
    abstract fun getTooltipContent(): String

    abstract fun getBlockId(): String

    override fun appendHoverText(
        stack: ItemStack,
        level: BlockGetter?,
        tooltip: MutableList<Component>,
        flag: TooltipFlag
    ) {
        tooltip.add(TranslatableComponent("tooltip.${getBlockId()}").withStyle(ChatFormatting.GRAY))
    }
}
