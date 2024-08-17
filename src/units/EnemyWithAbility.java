package units;

import enemies.Enemy;
import interfaces.Ability;

import java.util.Random;

public abstract class EnemyWithAbility extends Enemy implements Ability {
    private int procentSuccessAbility;

    public EnemyWithAbility(int health, int basicDamage, int procentSuccessAbility) {
        super(health, basicDamage);
        this.procentSuccessAbility = procentSuccessAbility;
    }

    @Override
    public  boolean canUseAbility(int percentSuccess) {
        final int PERCENT = (percentSuccess <= 1 || percentSuccess >= 100)
                ? new Random().nextInt(1,101)
                : percentSuccess ;

        int i = new Random().nextInt(1,101);
        if (i <= PERCENT) {  // удачно способность можно применить
            return true;
        }
        return false;
    }

    public int getProcentSuccessAbility() {
        return procentSuccessAbility;
    }

    public void setProcentSuccessAbility(int procentSuccessAbility) {
        this.procentSuccessAbility = procentSuccessAbility;
    }
}
