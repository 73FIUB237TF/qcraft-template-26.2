package com.qcraft;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;

public class PurpleHeartData {
    private static final String HEART_COUNT_KEY = "PurpleHeartCount";
    
    public static int getHeartCount(Player player) {
        CompoundTag persistentData = player.getPersistentData();
        if (persistentData.contains(HEART_COUNT_KEY)) {
            return persistentData.getInt(HEART_COUNT_KEY);
        }
        return 0;
    }
    
    public static void setHeartCount(Player player, int count) {
        CompoundTag persistentData = player.getPersistentData();
        persistentData.putInt(HEART_COUNT_KEY, Math.min(count, 10));
    }
}
