package com.qcraft;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

public class PurpleHeartBenefits {
    
    public static void applyBenefits(Player player, int heartCount) {
        // Remove all previous purple heart effects first
        removePreviousBenefits(player);
        
        // Apply benefits based on heart count
        switch (heartCount) {
            case 1:
                // 1 heart: Double jump
                player.getAbilities().mayFly = true;
                player.onUpdateAbilities();
                break;
            case 2:
                // 2 hearts: Increased damage
                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, 0, false, false));
                break;
            case 3:
                // 3 hearts: Speed boost
                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, -1, 1, false, false));
                break;
            case 4:
                // 4 hearts: Resistance
                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, -1, 0, false, false));
                break;
            case 5:
                // 5 hearts: Jump boost + double jump
                player.addEffect(new MobEffectInstance(MobEffects.JUMP, -1, 1, false, false));
                player.getAbilities().mayFly = true;
                player.onUpdateAbilities();
                break;
            case 6:
                // 6 hearts: Higher damage boost
                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, 1, false, false));
                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, -1, 1, false, false));
                break;
            case 7:
                // 7 hearts: Fire resistance
                player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, -1, 0, false, false));
                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, 1, false, false));
                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, -1, 1, false, false));
                break;
            case 8:
                // 8 hearts: Water breathing + better resistance
                player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, -1, 0, false, false));
                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, -1, 1, false, false));
                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, 1, false, false));
                break;
            case 9:
                // 9 hearts: All previous + regeneration
                player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 0, false, false));
                player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, -1, 0, false, false));
                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, -1, 1, false, false));
                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, 2, false, false));
                break;
            case 10:
                // 10 hearts: Maximum power - all benefits
                player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 1, false, false));
                player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, -1, 0, false, false));
                player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, -1, 0, false, false));
                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, -1, 2, false, false));
                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, 2, false, false));
                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, -1, 2, false, false));
                player.getAbilities().mayFly = true;
                player.onUpdateAbilities();
                break;
            default:
                break;
        }
    }
    
    public static void removePreviousBenefits(Player player) {
        // Remove all potion effects that we might have applied
        player.removeEffect(MobEffects.DAMAGE_BOOST);
        player.removeEffect(MobEffects.MOVEMENT_SPEED);
        player.removeEffect(MobEffects.DAMAGE_RESISTANCE);
        player.removeEffect(MobEffects.JUMP);
        player.removeEffect(MobEffects.FIRE_RESISTANCE);
        player.removeEffect(MobEffects.WATER_BREATHING);
        player.removeEffect(MobEffects.REGENERATION);
        
        // Reset flying ability (will be re-enabled if needed)
        player.getAbilities().mayFly = false;
        player.onUpdateAbilities();
    }
}
