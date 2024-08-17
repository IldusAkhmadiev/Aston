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


    public int getProcentSuccessAbility() {
        return procentSuccessAbility;
    }

    public void setProcentSuccessAbility(int procentSuccessAbility) {
        this.procentSuccessAbility = procentSuccessAbility;
    }


}
