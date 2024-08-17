package battle;

import enemies.Enemy;
import enemies.Troll;
import enemies.Zombie;
import heroes.Archer;

public class BattleGround {
    public static void main(String[] args) {
        Archer legolas = new Archer(100, 40, "Legolas");

        Enemy enemy = new Enemy(30, 10);
        Enemy enemy1 = new Zombie(30,5,10);
        Troll enemy2 = new Troll(200,20,90);
        legolas.attackEnemy(enemy);
        legolas.attackEnemy(enemy1);
        enemy1.isAlive();
        enemy.attackEnemy(legolas);
        enemy2.attackEnemy(legolas);
        enemy2.useAbility(legolas);


    }
}
