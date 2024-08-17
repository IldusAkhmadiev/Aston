package heroes;

import enemies.Enemy;

public abstract class Hero {
    private String name;
    private int basicDamage ;

    public Hero(String name,int basicDamage) {
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
}
