package units;

import interfaces.Mortal;

import java.io.Serializable;

public abstract class MortalUnit extends Unit implements Mortal {

    public MortalUnit(int health, int basicDamage) {
        super(health, basicDamage);
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
}
