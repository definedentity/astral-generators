package dev.definedentity.astralgenerators.block.convergence_core

import dev.definedentity.astralgenerators.AstralGenerators
import dev.definedentity.astralgenerators.registry.BlockRegistry
import java.util.function.Consumer
import java.util.function.Supplier
import mod.azure.azurelib.animatable.GeoItem
import mod.azure.azurelib.animatable.SingletonGeoAnimatable
import mod.azure.azurelib.animatable.client.RenderProvider
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
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer
import net.minecraft.world.item.BlockItem

class ConvergenceCoreItem :
    BlockItem(
        BlockRegistry.CONVERGENCE_CORE,
        FabricItemSettings().tab(AstralGenerators.ITEM_GROUP)
    ),
    GeoItem {
    val cache = AzureLibUtil.createInstanceCache(this)
    val CCRenderProvider = GeoItem.makeRenderer(this)

    init {
        SingletonGeoAnimatable.registerSyncedAnimatable(this)
    }

    override fun createRenderer(consumer: Consumer<in Any>) {
        consumer.accept(
            object : RenderProvider {
                val renderer = ConvergenceCoreItemRenderer()

                override fun getCustomRenderer(): BlockEntityWithoutLevelRenderer? {
                    return renderer
                }
            }
        )
    }

    override fun getRenderProvider(): Supplier<in Any>? {
        return CCRenderProvider
    }

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

    override fun getTick(itemStack: Any?): Double {
        return RenderUtils.getCurrentTick()
    }
}
