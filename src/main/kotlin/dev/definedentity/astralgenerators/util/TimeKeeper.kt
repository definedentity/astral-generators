package dev.definedentity.astralgenerators.util

object TimeKeeper {

    private var serverTick: Int = 0
    private var clientTick: Int = 0

    // Increment server tick counter
    fun incrementServerTick() {
        serverTick++
    }

    // Increment client tick counter
    fun incrementClientTick() {
        clientTick++
    }

    // Retrieve server tick count
    fun getServerTick(): Int {
        return serverTick
    }

    // Retrieve client tick count
    fun getClientTick(): Int {
        return clientTick
    }

    /**
     * Calculates the interval based on the current tick count.
     *
     * @param intervalTicks The number of ticks per interval.
     * @param rollover The rollover value for the interval.
     * @return The current interval value.
     */
    fun interval(intervalTicks: Int, rollover: Int): Int {
        return if (isClientSide()) {
            (getClientTick() / intervalTicks) % rollover
        } else {
            (getServerTick() / intervalTicks) % rollover
        }
    }

    private fun isClientSide(): Boolean {
        return net.fabricmc.api.EnvType.CLIENT ==
            net.fabricmc.loader.api.FabricLoader.getInstance().environmentType
    }
}
