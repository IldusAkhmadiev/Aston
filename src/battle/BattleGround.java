package battle;

import enemies.Enemy;
import heroes.Archer;

public class BattleGround {
    public static void main(String[] args) {
        new Archer("Legolas",10).attackEnemy(new Enemy(100));
    }
}
