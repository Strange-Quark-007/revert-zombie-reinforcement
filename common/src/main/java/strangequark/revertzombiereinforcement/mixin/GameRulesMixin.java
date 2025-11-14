package strangequark.revertzombiereinforcement.mixin;


import net.minecraft.world.level.GameRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import strangequark.revertzombiereinforcement.CommonClass;

@Mixin(GameRules.class)
public abstract class GameRulesMixin {

    @Invoker("register")
    private static <T extends GameRules.Value<T>>
    GameRules.Key<T> callRegister(String name, GameRules.Category category, GameRules.Type<T> type) {
        throw new AssertionError();
    }


    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void addRule(CallbackInfo ci) {
        CommonClass.RULE_REVERT_ZOMBIE_REINFORCEMENT = callRegister(
                "revertZombieReinforcement",
                GameRules.Category.MOBS,
                GameRuleCreateAccessor.callCreate(true)
        );
    }
}
