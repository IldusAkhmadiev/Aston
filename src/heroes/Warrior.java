package heroes;

import enemies.Enemy;
import units.Hero;
import units.Unit;

public class Warrior extends Hero {


    public Warrior(int health, int basicDamage, String name) {
        super(health, basicDamage, name);
    }

    @Override
    public <T extends Unit> void useAbility(T unit) {
        unit.setHealth(unit.getHealth() - getBasicDamage() * 3);
    }
}
