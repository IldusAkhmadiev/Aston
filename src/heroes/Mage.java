package heroes;

import enemies.Enemy;
import units.Hero;

public class Mage extends Hero {

    public Mage(int health, int basicDamage, String name) {
        super(health, basicDamage, name);
    }

    @Override
    public void attackEnemy(Enemy enemy) {
        enemy.takeDamage(getBasicDamage());
        System.out.println(this + " " + getName() + " атакует врага");
    }
}
