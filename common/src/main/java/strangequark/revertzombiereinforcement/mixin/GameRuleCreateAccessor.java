package strangequark.revertzombiereinforcement.mixin;

import net.minecraft.world.level.GameRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(GameRules.BooleanValue.class)
public interface GameRuleCreateAccessor {
    @Invoker("create")
    static GameRules.Type<GameRules.BooleanValue> callCreate(boolean defaultValue) {
        throw new AssertionError();
    }
}
