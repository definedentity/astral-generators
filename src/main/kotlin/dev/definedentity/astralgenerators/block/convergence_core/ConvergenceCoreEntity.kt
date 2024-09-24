package dev.definedentity.astralgenerators.block.convergence_core

import dev.definedentity.astralgenerators.registry.BlockEntityRegistry
import mod.azure.azurelib.animatable.GeoBlockEntity
import mod.azure.azurelib.core.animatable.GeoAnimatable
import mod.azure.azurelib.core.animatable.instance.AnimatableInstanceCache
import mod.azure.azurelib.core.animation.AnimatableManager
import mod.azure.azurelib.core.animation.Animation
import mod.azure.azurelib.core.animation.AnimationController
import mod.azure.azurelib.core.animation.AnimationState
import mod.azure.azurelib.core.animation.RawAnimation
import mod.azure.azurelib.core.`object`.PlayState
import mod.azure.azurelib.util.AzureLibUtil
import mod.azure.azurelib.util.RenderUtils
import net.minecraft.core.BlockPos
import net.minecraft.world.level.block.entity.BlockEntity
import net.minecraft.world.level.block.state.BlockState

class ConvergenceCoreEntity(pos: BlockPos, state: BlockState) :
    BlockEntity(BlockEntityRegistry.CONVERGENCE_CORE_ENTITY, pos, state), GeoBlockEntity {

    val cache = AzureLibUtil.createInstanceCache(this)

    override fun registerControllers(controllers: AnimatableManager.ControllerRegistrar) {
        controllers.add(AnimationController(this, "controller", 0, this::predicate))
    }

    private fun <T : GeoAnimatable> predicate(tAnimationState: AnimationState<T>): PlayState {
        tAnimationState.controller.setAnimation(
            RawAnimation.begin().then("idle", Animation.LoopType.LOOP)
        )
        return PlayState.CONTINUE
    }

    override fun getAnimatableInstanceCache(): AnimatableInstanceCache? {
        return cache
    }

    override fun getTick(`object`: Any?): Double {
        return RenderUtils.getCurrentTick()
    }
}
