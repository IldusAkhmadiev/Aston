package battle;

import enemies.Enemy;
import heroes.Archer;

public class BattleGround {
    public static void main(String[] args) {
        Archer legolas = new Archer(100, 10, "Legolas");

        Enemy enemy = new Enemy(100, 10);
        legolas.attackEnemy(enemy);
        enemy.attackEnemy(legolas);

    }
}
