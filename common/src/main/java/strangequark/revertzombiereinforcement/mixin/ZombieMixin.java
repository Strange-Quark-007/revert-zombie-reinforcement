package strangequark.revertzombiereinforcement.mixin;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Zombie;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Zombie.class)
public class ZombieMixin {
    @Redirect(method = "hurtServer", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/monster/Zombie;getType()Lnet/minecraft/world/entity/EntityType;"))
    public EntityType<? extends Zombie> redirectGetType(Zombie instance){
        return EntityType.ZOMBIE;
    }
}
