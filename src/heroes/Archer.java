package heroes;

import enemies.Enemy;
import units.Hero;
import units.Unit;

import java.util.Random;

public class Archer extends Hero {


    public Archer(int health, int basicDamage, String name, int procentSuccessAbility) {
        super(health, basicDamage, name, procentSuccessAbility);
    }

    @Override
    public <T extends Unit> void useAbility(T unit) {
        int damage = getBasicDamage() * 2;
        System.out.println(this + " использовал супер выстрел против " + unit + " нанесено " + damage +
                " урона у врага осталось : " + (unit.getHealth() -damage));
        unit.setHealth(unit.getHealth() - damage);
    }
}
