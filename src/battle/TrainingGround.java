package battle;

import enemies.Enemy;
import heroes.Archer;
import heroes.Hero;
import heroes.Mage;
import heroes.Warrior;

public class TrainingGround {
    public static void main(String[] args) {
        new Mage("Mag1",15).attackEnemy(new Enemy(100));
        new Warrior("Warrior1",20).attackEnemy(new Enemy(100));
        new Archer("Archer1",10).attackEnemy(new Enemy(100));
    }
}
