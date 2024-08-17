package enemies;

import units.EnemyWithAbility;
import units.Hero;
import units.Unit;

import java.util.ArrayList;
import java.util.List;

public class Troll extends EnemyWithAbility {

    public Troll(int health, int basicDamage, int procentSuccessAbility) {
        super(health, basicDamage, procentSuccessAbility);
    }


    @Override
    public <T extends Unit> void useAbility(T unit) {
        if(canUseAbility(getProcentSuccessAbility())) {
            System.out.println("Троль наносит супер удар " + getBasicDamage() * 2 + " урона");
            unit.setHealth(unit.getHealth() - getBasicDamage() * 2);
            System.out.println( ((Hero) unit).getName()  + " чувствует себя не очень хорошего у " + ((Hero) unit).getName()  + " осталось " + unit.getHealth());
        }
    }
}
