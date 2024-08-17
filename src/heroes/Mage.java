package heroes;

import enemies.Enemy;

public class Mage extends Hero{

    public Mage(String name, int basicDamage) {
        super(name, basicDamage);
    }
    @Override
    public void attackEnemy(Enemy enemy) {
        enemy.takeDamage(getBasicDamage());
        System.out.println(this + " " + getName() + " атакует врага");
    }
}
