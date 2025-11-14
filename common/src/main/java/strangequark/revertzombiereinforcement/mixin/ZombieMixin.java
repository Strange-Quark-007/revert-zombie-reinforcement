package strangequark.revertzombiereinforcement.mixin;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Zombie;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import strangequark.revertzombiereinforcement.CommonClass;

@Mixin(Zombie.class)
public class ZombieMixin {

    @Redirect(method = "hurtServer", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/monster/Zombie;getType()Lnet/minecraft/world/entity/EntityType;"))
    public EntityType<? extends Zombie> redirectGetType(Zombie zombie) {
        var level = zombie.level();

        if (!(level instanceof ServerLevel serverLevel)) {
            return zombie.getType();
        }

        if (!serverLevel.getGameRules().getBoolean(CommonClass.RULE_REVERT_ZOMBIE_REINFORCEMENT)) {
            return zombie.getType();
        }

        return EntityType.ZOMBIE;
    }
}
