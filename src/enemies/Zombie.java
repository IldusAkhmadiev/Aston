package enemies;

import interfaces.Ability;
import units.EnemyWithAbility;
import units.Unit;

import java.util.Random;

public class Zombie extends EnemyWithAbility {
    private int initHealth;  // используется когда зомби воскрешает

    public Zombie(int health, int basicDamage, int procentSuccessAbility) {
        super(health, basicDamage, procentSuccessAbility);
    }

    @Override
    public boolean isAlive() {
        if(super.isAlive() ) {
            return true;
        } else {
            if(canUseAbility(getProcentSuccessAbility())) {
                useAbility(this);
            }
        }
        System.out.println("Зомби умер окончательно");
        return false;
    }

    @Override
    public <T extends Unit> void useAbility(T unit) {
        System.out.println("Зомби " + unit + " воскрешает");
    }
}
