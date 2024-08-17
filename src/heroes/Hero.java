package heroes;

import enemies.Enemy;
import interfaces.Mortal;

public abstract class Hero implements Mortal {
    private String name;
    private int basicDamage;
    private int health;

    public Hero(String name, int basicDamage) {
        this.name = name;
        this.basicDamage = basicDamage;
    }

    public int getBasicDamage() {
        return basicDamage;
    }

    public void setBasicDamage(int basicDamage) {
        this.basicDamage = basicDamage;
    }

    public String getName() {
        return name;
    }

    public abstract void attackEnemy(Enemy enemy);

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

    @Override
    public boolean isAlive() {
        if (health > 0) {
            return true;
        }
        return false;
    }

    public void takeDamage(int damage) {
        health -= damage;
    }


}
