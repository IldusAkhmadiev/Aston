package units;

import interfaces.Ability;

import java.util.Random;

public abstract class EnemyWithAbility extends MortalUnitWithAbility {

    public EnemyWithAbility(int health, int basicDamage, int procentSuccessAbility) {
        super(health, basicDamage, procentSuccessAbility);
    }
}
