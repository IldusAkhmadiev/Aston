package enemies;

import units.EnemyWithAbility;
import units.Hero;
import units.Unit;

public class Enemy extends EnemyWithAbility {

    public Enemy(int health, int basicDamage, int procentSuccessAbility) {
        super(health, basicDamage, procentSuccessAbility);
    }

    public <T extends Hero> void attackEnemy(T hero) {
        hero.takeDamage(getBasicDamage()); // Герой получает урон
        System.out.println(String.format("%s атакует %s, нанесено %d урона у %s осталось %d жизни",
                this, hero.getName(), getBasicDamage(), hero.getName(), ( (hero.getHealth() < 0) ? 0 : (hero.getHealth()) ) ));
    }


    @Override
    public <T extends Unit> void useAbility(T unit) {
        System.out.println(this + " наносит обычный удар нанесено : " + getBasicDamage() + " урона.");
        unit.setHealth(unit.getHealth() - getBasicDamage());
    }
}
