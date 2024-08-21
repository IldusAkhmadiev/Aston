package units;

import interfaces.Ability;

import java.util.Random;

public abstract class MortalUnitWithAbility extends MortalUnit implements Ability {
    private int procentSuccessAbility;


    public MortalUnitWithAbility(int health, int basicDamage, int procentSuccessAbility) {
        super(health, basicDamage);
        this.procentSuccessAbility = procentSuccessAbility;
    }

    @Override
    public boolean canUseAbility(int percentSuccess) {
        return Ability.super.canUseAbility(percentSuccess);
    }

    @Override
    public <T extends Unit> void useAbility(T unit) {

    }

    public boolean canUseAbility() {
        int i = new Random().nextInt(1,101);
        if (i <= getProcentSuccessAbility()) {  // удачно способность можно применить
            return true;
        }
        System.out.println(this + " не смог активировать суперспособность");
        return false;
    }

    public int getProcentSuccessAbility() {
        return procentSuccessAbility;
    }

    public void setProcentSuccessAbility(int procentSuccessAbility) {
        this.procentSuccessAbility = procentSuccessAbility;
    }
}
