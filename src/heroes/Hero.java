package heroes;

import enemies.Enemy;

public abstract class Hero {
    private String name;
    private int basicDamage ;

    public Hero(String name,int basicDamage) {
        this.name = name;
        this.basicDamage = basicDamage;
    }


    public String getName() {
        return name;
    }

    public void attackEnemy(Enemy enemy) {
        enemy.takeDamage(basicDamage);
        System.out.println(this + " " + getName() + " атакует врага");
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
