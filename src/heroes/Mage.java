package heroes;

import enemies.Enemy;
import units.Hero;
import units.Unit;

public class Mage extends Hero {

    public Mage(int health, int basicDamage, String name) {
        super(health, basicDamage, name);
    }

    @Override
    public <T extends Unit> void useAbility(T unit) {
        if (unit instanceof Hero) {
            unit.setHealth(unit.getHealth() + 60);
        }
    }
}
