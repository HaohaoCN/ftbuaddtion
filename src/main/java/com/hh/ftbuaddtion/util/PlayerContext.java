package com.hh.ftbuaddtion.util;

import net.minecraft.server.level.ServerPlayer;

public class PlayerContext {
    private static final ThreadLocal<ServerPlayer> currentPlayer = new ThreadLocal<>();

    public static void setPlayer(ServerPlayer player) {
        currentPlayer.set(player);
    }

    public static ServerPlayer getPlayer() {
        return currentPlayer.get();
    }

    public static void clear() {
        currentPlayer.remove();
    }
}