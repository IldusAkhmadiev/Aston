package heroes;

import enemies.Enemy;
import interfaces.Mortal;
import units.MortalUnit;

public abstract class Hero extends MortalUnit {
    private String name;

    public Hero(int health, int basicDamage, String name) {
        super(health, basicDamage);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void attackEnemy(Enemy enemy);

    public void takeDamage(int damage) {
        setHealth(getHealth() -damage);
    }


}
