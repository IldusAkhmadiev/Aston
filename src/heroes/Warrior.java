package heroes;

import enemies.Enemy;

public class Warrior extends Hero{


    public Warrior(String name, int basicDamage) {
        super(name, basicDamage);
    }

    @Override
    public void attackEnemy(Enemy enemy) {
        enemy.takeDamage(getBasicDamage());
        System.out.println(this + " " + getName() + " атакует врага");
    }
}
