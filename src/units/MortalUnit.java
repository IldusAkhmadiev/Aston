package units;

import interfaces.Mortal;

import java.io.Serializable;
import java.util.Random;

public abstract class MortalUnit extends Unit implements Mortal {
    private int procentSuccessAbility;

    public MortalUnit(int health, int basicDamage, int procentSuccessAbility) {
        super(health, basicDamage);
        this.procentSuccessAbility = procentSuccessAbility;
    }

    @Override
    public boolean isAlive() {
        if(getHealth() > 0) {
            return true;
        }
        return false;
    }
    public void takeDamage(int damage) {
        setHealth(getHealth() - damage);
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
