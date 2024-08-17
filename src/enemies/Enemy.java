package enemies;

import interfaces.Mortal;
import heroes.Hero;

public class Enemy implements Mortal {
    private int health;
    private int basicDamage;

    public Enemy(int health, int basicDamage) {
        this.health = health;
        this.basicDamage = basicDamage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void takeDamage(int damage) {
        health -= damage;
    }

    @Override
    public boolean isAlive() {
        if(health > 0) {
            return true;
        }
        return false;
    }

    public void attackEnemy(Hero hero) {
        hero.takeDamage(basicDamage);
        System.out.println(this + " атакует " + hero);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
