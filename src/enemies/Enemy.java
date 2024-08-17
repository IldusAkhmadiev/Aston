package enemies;

import interfaces.Mortal;
import heroes.Hero;
import units.MortalUnit;

public class Enemy extends MortalUnit {

    public Enemy(int health, int basicDamage) {
        super(health, basicDamage);
    }

    public void takeDamage(int damage) {
        setHealth(getHealth() - damage);
    }

    public void attackEnemy(Hero hero) {
        hero.takeDamage(getBasicDamage());
        System.out.println(this + " атакует " + hero);
    }

}
