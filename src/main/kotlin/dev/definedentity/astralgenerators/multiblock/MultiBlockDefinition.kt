package dev.definedentity.astralgenerators.multiblock

import com.google.common.collect.ImmutableMap
import com.google.gson.JsonElement
import definedentity.xenon.vec.Rotation
import definedentity.xenon.vec.Vector3
import java.util.ArrayList
import net.minecraft.core.BlockPos
import net.minecraft.core.Registry
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.Blocks

class MultiBlockDefinition(private val id: ResourceLocation, private val json: JsonElement) {
    private var origin = BlockPos.ZERO
    private val blockMap = hashMapOf<BlockPos, MultiBlockPart>()

    init {
        loadFromJson()
    }

    fun loadFromJson() {
        val obj = json.asJsonObject

        // Handle origin field
        if (obj.has("origin")) {
            val origin = obj.get("origin").asJsonObject
            this.origin =
                BlockPos(origin.get("x").asInt, origin.get("y").asInt, origin.get("z").asInt)
        }

        // Handle key field
        val keyMap = hashMapOf<String, MultiBlockPart>()
        val keysObj = obj.get("keys").asJsonObject

        for (key in keysObj.entrySet()) {
            val keyName = key.key

            if (keyMap.containsKey(keyName)) {
                throw IllegalArgumentException("Duplicate key name: $keyName")
            }

            val keyVal = key.value.asJsonObject

            if (keyVal.has("block")) {
                val resourceLocation = ResourceLocation(keyVal.get("block").asString)

                if (Registry.BLOCK.get(resourceLocation) == Blocks.AIR) {
                    keyMap[keyName] = EmptyPart()
                } else {
                    keyMap[keyName] = BlockPart(resourceLocation)
                }
            } else {
                throw IllegalArgumentException("Invalid key definition: $keyName")
            }
        }

        // Handle pattern field
        val structure = obj.get("pattern").asJsonArray

        for ((layer, layerElement) in structure.withIndex()) {
            val layerArray = layerElement.asJsonArray

            for ((row, rowElement) in layerArray.withIndex()) {
                val rowString = rowElement.asString

                for (i in rowString.indices) {
                    val key = rowString[i].toString()
                    val pos = BlockPos(i, layer, row).subtract(origin)

                    if (blockMap.containsKey(pos)) {
                        throw IllegalArgumentException("Duplicate block position: $pos")
                    }

                    if (key != " ") {
                        if (!keyMap.containsKey(key)) {
                            throw IllegalArgumentException(
                                "Undefined key in multiblock definition: $id, Key: $key"
                            )
                        }

                        blockMap[pos] = keyMap[key]!!
                    }
                }
            }
        }
    }

    fun getId(): ResourceLocation {
        return id
    }

    fun getJson(): JsonElement {
        return json
    }

    fun getBlocks(): ImmutableMap<BlockPos, MultiBlockPart> {
        return ImmutableMap.copyOf(blockMap)
    }

    fun getBlockAt(worldOrigin: BlockPos): ImmutableMap<BlockPos, MultiBlockPart> {
        val translated = hashMapOf<BlockPos, MultiBlockPart>()

        blockMap.forEach { (pos, part) -> translated[worldOrigin.offset(pos)] = part }

        return ImmutableMap.copyOf(translated)
    }

    fun getBlocks(rotation: Rotation): ImmutableMap<BlockPos, MultiBlockPart> {
        val transformed = hashMapOf<BlockPos, MultiBlockPart>()
        val transform = rotation.at(Vector3.CENTER).inverse()

        blockMap.forEach { (pos, part) ->
            val vec = Vector3.fromBlockPosCenter(pos)
            vec.apply(transform)
            transformed[vec.pos()] = part
        }

        return ImmutableMap.copyOf(transformed)
    }

    fun getBlockAt(
        worldOrigin: BlockPos,
        rotation: Rotation
    ): ImmutableMap<BlockPos, MultiBlockPart> {
        val transformed = hashMapOf<BlockPos, MultiBlockPart>()
        val transform = rotation.at(Vector3.CENTER).inverse()

        blockMap.forEach { (pos, part) ->
            val vec = Vector3.fromBlockPosCenter(pos)
            vec.apply(transform)
            transformed[vec.add(worldOrigin).pos()] = part
        }

        return ImmutableMap.copyOf(transformed)
    }

    fun test(level: Level, originPos: BlockPos): ArrayList<InvalidPart> {
        val result = ArrayList<InvalidPart>()

        getBlockAt(originPos).forEach { (pos, part) ->
            if (!part.isMatch(level, pos)) {
                result.add(InvalidPart(pos, part))
            }
        }

        return result
    }

    fun test(level: Level, originPos: BlockPos, rotation: Rotation): ArrayList<InvalidPart> {
        val result = ArrayList<InvalidPart>()

        getBlockAt(originPos, rotation).forEach { (pos, part) ->
            if (!part.isMatch(level, pos)) {
                result.add(InvalidPart(pos, part))
            }
        }

        return result
    }
}
