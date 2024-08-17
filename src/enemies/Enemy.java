package enemies;

import units.Hero;
import units.MortalUnit;

public class Enemy extends MortalUnit {

    public Enemy(int health, int basicDamage) {
        super(health, basicDamage);
    }

    public <T extends Hero> void attackEnemy(T hero) {
        hero.takeDamage(getBasicDamage()); // Герой получает урон
        System.out.println(String.format("%s атакует %s, нанесено %d урона у %s осталось %d жизни",
                this, hero.getName(), getBasicDamage(), hero.getName(), hero.getHealth()));
    }

}
