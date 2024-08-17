package units;

import enemies.Enemy;
import interfaces.Ability;

import java.util.Random;

public abstract class Hero extends MortalUnit implements Ability {
    private String name;
    private int procentSuccessAbility;

    public Hero(int health, int basicDamage, String name, int procentSuccessAbility) {
        super(health, basicDamage);
        this.name = name;
        this.procentSuccessAbility = procentSuccessAbility;
    }


    public String getName() {
        return name;
    }

    public <T extends Enemy> void attackEnemy(T enemy) {
        enemy.takeDamage(getBasicDamage());
        System.out.println(this + " " + getName() + " атакует врага " + enemy + " нанесено урона " + this.getBasicDamage());
    }

    public int getProcentSuccessAbility() {
        return procentSuccessAbility;
    }

    public void setProcentSuccessAbility(int procentSuccessAbility) {
        this.procentSuccessAbility = procentSuccessAbility;
    }

    public boolean canUseAbility() {
        int i = new Random().nextInt(1,101);
        if (i <= getProcentSuccessAbility()) {  // удачно способность можно применить
            return true;
        }
        System.out.println(this + " не смог активировать суперспособность");
        return false;
    }
}
