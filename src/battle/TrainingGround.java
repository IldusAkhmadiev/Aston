package battle;

import heroes.Archer;
import heroes.Hero;
import heroes.Mage;
import heroes.Warrior;

public class TrainingGround {
    public static void main(String[] args) {
        new Mage("Mag1").attackEnemy();
        new Warrior("Warrior1").attackEnemy();
        new Archer("Archer1").attackEnemy();
    }
}
