package units;

import enemies.Enemy;

public abstract class Hero extends MortalUnit {
    private String name;

    public Hero(int health, int basicDamage, String name) {
        super(health, basicDamage);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract <T extends Enemy> void attackEnemy(T enemy);


}
