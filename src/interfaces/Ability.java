package interfaces;

import units.Unit;

public interface Ability {
    boolean canUseAbility(int percentSuccess);

    <T extends Unit> void useAbility(T unit);
}

