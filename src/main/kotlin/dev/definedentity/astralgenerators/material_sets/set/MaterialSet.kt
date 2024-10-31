package dev.definedentity.astralgenerators.material_sets.set

import com.tterrag.registrate.util.entry.BlockEntry
import com.tterrag.registrate.util.entry.ItemEntry
import dev.definedentity.astralgenerators.AstralGenerators.Companion.REGISTRATE
import dev.definedentity.astralgenerators.utils.TextFormatting
import java.util.function.Supplier
import net.minecraft.client.color.block.BlockColor
import net.minecraft.client.color.item.ItemColor
import net.minecraft.client.renderer.RenderType
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.state.BlockBehaviour
import net.minecraft.world.level.material.Material

class MaterialSet(val name: String, val color: Int) {
    private val NUGGET = nugget("${name}_nugget", ::Item)
    private val INGOT = ingot("${name}_ingot", ::Item)
    private val BLOCK = block("${name}_block", ::Block)
    private val DUST = dust("${name}_dust", ::Item)
    private val PLATE = plate("${name}_plate", ::Item)
    private val ROD = rod("${name}_rod", ::Item)
    private val WIRE_FINE = wire_fine("${name}_wire_fine", ::Item)
    private val GEAR = gear("${name}_gear", ::Item)
    private val FOIL = foil("${name}_foil", ::Item)
    private val FRAME = frame("${name}_frame", ::Block)

    fun <T : Item> foil(name: String, itemSupplier: (Item.Properties) -> T): ItemEntry<T> {
        return REGISTRATE.item(name, itemSupplier)
            .lang(TextFormatting.toEnglishName(name))
            .color {
                object : Supplier<ItemColor> {
                    override fun get(): ItemColor {
                        return ItemColor { stack, index -> color }
                    }
                }
            }
            .model { ctx, prov ->
                prov.withExistingParent(ctx.name, prov.modLoc("item/material_sets/foil"))
            }
            .register()
    }

    fun <T : Item> gear(name: String, itemSupplier: (Item.Properties) -> T): ItemEntry<T> {
        return REGISTRATE.item(name, itemSupplier)
            .lang(TextFormatting.toEnglishName(name))
            .color {
                object : Supplier<ItemColor> {
                    override fun get(): ItemColor {
                        return ItemColor { stack, index -> color }
                    }
                }
            }
            .model { ctx, prov ->
                prov.withExistingParent(ctx.name, prov.modLoc("item/material_sets/gear"))
            }
            .register()
    }

    fun <T : Item> wire_fine(name: String, itemSupplier: (Item.Properties) -> T): ItemEntry<T> {
        return REGISTRATE.item(name, itemSupplier)
            .lang(TextFormatting.toEnglishName(name))
            .color {
                object : Supplier<ItemColor> {
                    override fun get(): ItemColor {
                        return ItemColor { stack, index -> color }
                    }
                }
            }
            .model { ctx, prov ->
                prov.withExistingParent(ctx.name, prov.modLoc("item/material_sets/wire_fine"))
            }
            .register()
    }

    fun <T : Item> rod(name: String, itemSupplier: (Item.Properties) -> T): ItemEntry<T> {
        return REGISTRATE.item(name, itemSupplier)
            .lang(TextFormatting.toEnglishName(name))
            .color {
                object : Supplier<ItemColor> {
                    override fun get(): ItemColor {
                        return ItemColor { stack, index -> color }
                    }
                }
            }
            .model { ctx, prov ->
                prov.withExistingParent(ctx.name, prov.modLoc("item/material_sets/rod"))
            }
            .register()
    }

    fun <T : Item> plate(name: String, itemSupplier: (Item.Properties) -> T): ItemEntry<T> {
        return REGISTRATE.item(name, itemSupplier)
            .lang(TextFormatting.toEnglishName(name))
            .color {
                object : Supplier<ItemColor> {
                    override fun get(): ItemColor {
                        return ItemColor { stack, index -> color }
                    }
                }
            }
            .model { ctx, prov ->
                prov.withExistingParent(ctx.name, prov.modLoc("item/material_sets/plate"))
            }
            .register()
    }

    fun <T : Item> dust(name: String, itemSupplier: (Item.Properties) -> T): ItemEntry<T> {
        return REGISTRATE.item(name, itemSupplier)
            .lang(TextFormatting.toEnglishName(name))
            .color {
                object : Supplier<ItemColor> {
                    override fun get(): ItemColor {
                        return ItemColor { stack, index -> color }
                    }
                }
            }
            .model { ctx, prov ->
                prov.withExistingParent(ctx.name, prov.modLoc("item/material_sets/dust"))
            }
            .register()
    }

    fun <T : Block> block(
        name: String,
        blockSupplier: (BlockBehaviour.Properties) -> T
    ): BlockEntry<T> {
        return REGISTRATE.block(name, blockSupplier)
            .lang(TextFormatting.toEnglishName(name))
            .properties { BlockBehaviour.Properties.of(Material.METAL).noOcclusion() }
            .blockstate { ctx, prov ->
                prov.simpleBlock(
                    ctx.entry,
                    prov
                        .models()
                        .withExistingParent(ctx.name, prov.modLoc("block/material_sets/block"))
                )
            }
            .addLayer { Supplier { RenderType.translucent() } }
            .color {
                object : Supplier<BlockColor> {
                    override fun get(): BlockColor {
                        return BlockColor { state, world, pos, index -> color }
                    }
                }
            }
            .item()
            .color {
                object : Supplier<ItemColor> {
                    override fun get(): ItemColor {
                        return ItemColor { stack, index -> color }
                    }
                }
            }
            .model { ctx, prov ->
                prov.withExistingParent(ctx.name, prov.modLoc("block/material_sets/block"))
            }
            .build()
            .register()
    }

    fun <T : Block> frame(
        name: String,
        blockSupplier: (BlockBehaviour.Properties) -> T
    ): BlockEntry<T> {
        return REGISTRATE.block(name, blockSupplier)
            .lang(TextFormatting.toEnglishName(name))
            .properties { BlockBehaviour.Properties.of(Material.METAL).noOcclusion() }
            .blockstate { ctx, prov ->
                prov.simpleBlock(
                    ctx.entry,
                    prov
                        .models()
                        .withExistingParent(ctx.name, prov.modLoc("block/material_sets/frame"))
                )
            }
            .addLayer { Supplier { RenderType.translucent() } }
            .color {
                object : Supplier<BlockColor> {
                    override fun get(): BlockColor {
                        return BlockColor { state, world, pos, index -> color }
                    }
                }
            }
            .item()
            .color {
                object : Supplier<ItemColor> {
                    override fun get(): ItemColor {
                        return ItemColor { stack, index -> color }
                    }
                }
            }
            .model { ctx, prov ->
                prov.withExistingParent(ctx.name, prov.modLoc("block/material_sets/frame"))
            }
            .build()
            .register()
    }

    fun <T : Item> ingot(name: String, itemSupplier: (Item.Properties) -> T): ItemEntry<T> {
        return REGISTRATE.item(name, itemSupplier)
            .lang(TextFormatting.toEnglishName(name))
            .color {
                object : Supplier<ItemColor> {
                    override fun get(): ItemColor {
                        return ItemColor { stack, index -> color }
                    }
                }
            }
            .model { ctx, prov ->
                prov.withExistingParent(ctx.name, prov.modLoc("item/material_sets/ingot"))
            }
            .register()
    }

    fun <T : Item> nugget(name: String, itemSupplier: (Item.Properties) -> T): ItemEntry<T> {
        return REGISTRATE.item(name, itemSupplier)
            .lang(TextFormatting.toEnglishName(name))
            .color {
                object : Supplier<ItemColor> {
                    override fun get(): ItemColor {
                        return ItemColor { stack, index -> color }
                    }
                }
            }
            .model { ctx, prov ->
                prov.withExistingParent(ctx.name, prov.modLoc("item/material_sets/nugget"))
            }
            .register()
    }
}
