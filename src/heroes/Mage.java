package heroes;

import enemies.Enemy;
import units.Hero;
import units.Unit;

import java.util.Random;

public class Mage extends Hero {

    public Mage(int health, int basicDamage, String name, int procentSuccessAbility) {
        super(health, basicDamage, name, procentSuccessAbility);
    }

    @Override
    public <T extends Unit> void useAbility(T unit) {
        if (unit instanceof Hero) {
            unit.setHealth(unit.getHealth() + 60);
            System.out.println(this.getName() + " лечит " + unit + " теперь у него " + unit.getHealth());
        }
    }
}
