package dev.definedentity.astralgenerators.item

import dev.definedentity.astralgenerators.fluid.Steam
import net.minecraft.ChatFormatting
import net.minecraft.network.chat.Component
import net.minecraft.network.chat.TranslatableComponent
import net.minecraft.sounds.SoundEvents
import net.minecraft.sounds.SoundSource
import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResultHolder
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.Items
import net.minecraft.world.item.TooltipFlag
import net.minecraft.world.level.Level

class SteamBucket : AGUpsideDownBucketItem(Steam.Source, Steam.COLOR) {
    companion object {
        val ID = "steam_bucket"
        val NAME = "Steam Bucket"
        val DESCRIPTION = Steam.DESCRIPTION
    }

    override fun appendHoverText(
        stack: ItemStack,
        world: Level?,
        tooltip: MutableList<Component>,
        context: TooltipFlag
    ) {
        tooltip.add(TranslatableComponent("tooltip.$ID").withStyle(ChatFormatting.GRAY))
    }

    override fun use(
        world: Level,
        user: Player,
        hand: InteractionHand
    ): InteractionResultHolder<ItemStack> {
        if (!world.isClientSide)
            return InteractionResultHolder.success(Items.BUCKET.defaultInstance)

        world.playLocalSound(
            user.x,
            user.y,
            user.z,
            SoundEvents.GENERIC_BURN,
            SoundSource.PLAYERS,
            1f,
            1f,
            true
        )
        return InteractionResultHolder.success(Items.BUCKET.defaultInstance)
    }
}
