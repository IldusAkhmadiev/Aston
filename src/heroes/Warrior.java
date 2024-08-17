package heroes;

import units.Hero;
import units.Unit;

public class Warrior extends Hero {


    public Warrior(int health, int basicDamage, String name, int procentSuccessAbility) {
        super(health, basicDamage, name, procentSuccessAbility);
    }

    @Override
    public <T extends Unit> void useAbility(T unit) {
        int damage = getBasicDamage() * 3;
        System.out.println(this + " использовал супер удар против " + unit + " нанесено " +damage
                + " урона у врага осталось : " + ((unit.getHealth() - damage < 0) ? 0 : (unit.getHealth() - damage)));
        unit.setHealth(unit.getHealth() - damage);
    }
}
