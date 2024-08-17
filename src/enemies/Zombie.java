package enemies;

import java.util.Random;

public class Zombie extends Enemy{
    private int initHealth;  // используется когда зомби воскрешает
    public Zombie(int health, int basicDamage) {
        super(health, basicDamage);
        initHealth = health;
    }

    @Override
    public boolean isAlive() {
        if(super.isAlive() ) {
            return true;
        }
        int i = new Random().nextInt(2); // шанс воскреснуть зомби 50% для наглядности
        if(i == 1){
            setHealth(initHealth);
        }
        return false;
    }
}
