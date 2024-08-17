package units;

import enemies.Enemy;
import interfaces.Ability;

public abstract class Hero extends MortalUnit implements Ability {
    private String name;

    public Hero(int health, int basicDamage,String name, int procentSuccessAbility) {
        super(health, basicDamage, procentSuccessAbility);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public <T extends Enemy> void attackEnemy(T enemy) {
        enemy.takeDamage(getBasicDamage());
        System.out.println(this + " " + getName() + " атакует врага " + enemy + " нанесено урона " + this.getBasicDamage() +
                " здоровье врага " + enemy.getHealth());
    }


}
