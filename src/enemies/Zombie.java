package enemies;

import interfaces.Ability;
import units.EnemyWithAbility;
import units.Unit;

import java.util.Random;

public class Zombie extends EnemyWithAbility {
    private int initHealth;  // используется когда зомби воскрешает
    static int counter =0;

    public Zombie(int health, int basicDamage, int procentSuccessAbility) {
        super(health, basicDamage, procentSuccessAbility);
        this.initHealth = health;
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
        return false;
    }

    @Override
    public <T extends Unit> void useAbility(T unit) {
        if(unit.getHealth() <= 0) {
            unit.setHealth(initHealth);
            System.out.println("Зомби " + unit + " воскрешает " + counter++ + " в раз  его здоровье " + unit.getHealth());
        }
    }

    public boolean canUseAbility() {
        int i = new Random().nextInt(1, 101);
        if (i <= getProcentSuccessAbility()) {  // удачно способность можно применить
            return true;
        }
        System.out.println(this + " не смог активировать суперспособность");
        return false;
    }

}
