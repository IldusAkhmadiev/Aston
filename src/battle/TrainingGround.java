package battle;

import enemies.Enemy;
import heroes.Archer;
import heroes.Hero;
import heroes.Mage;
import heroes.Warrior;

import java.util.Random;

public class TrainingGround {
    public static void main(String[] args) {
        new Mage("Mag1",15).attackEnemy(new Enemy(100,5));
        new Warrior("Warrior1",20).attackEnemy(new Enemy(100,3));
        new Archer("Archer1",10).attackEnemy(new Enemy(100,8));

    }
}
