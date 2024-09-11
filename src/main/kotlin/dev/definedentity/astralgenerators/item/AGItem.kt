package dev.definedentity.astralgenerators.item

import dev.definedentity.astralgenerators.AstralGenerators
import net.minecraft.network.chat.Component
import net.minecraft.network.chat.TranslatableComponent
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.TooltipFlag
import net.minecraft.world.level.Level

abstract class AGItem(settings: Properties): Item(settings.tab(AstralGenerators.ITEM_GROUP)) {
}