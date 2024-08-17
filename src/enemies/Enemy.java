package enemies;

import enemies.interfaces.Mortal;
import heroes.Hero;

public class Enemy implements Mortal {
    private int health;
    private Hero hero;

    public Enemy(int health) {
        this.health = health;
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
}
