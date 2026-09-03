package com.qcraft;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class PurpleHeartItem extends Item {
    public PurpleHeartItem(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entityLiving) {
        ItemStack result = super.finishUsingItem(stack, level, entityLiving);
        
        if (entityLiving instanceof Player player) {
            // Get current heart count and increment
            int currentHearts = PurpleHeartData.getHeartCount(player);
            int newHearts = Math.min(currentHearts + 1, 10);
            PurpleHeartData.setHeartCount(player, newHearts);
            
            // Apply benefits based on heart count
            PurpleHeartBenefits.applyBenefits(player, newHearts);
        }
        
        return result;
    }
}
