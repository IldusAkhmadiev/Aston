package battle;

import enemies.Enemy;
import enemies.Troll;
import enemies.Zombie;
import heroes.Archer;
import heroes.Mage;
import heroes.Warrior;
import units.Hero;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BattleGround {
    public static void main(String[] args) {

        List<Enemy> enemies = new ArrayList<>();
        List<Hero> heroes = new ArrayList<>();

        Archer legolas = new Archer(140, 15, "Legolas");
        Mage mage = new Mage(120, 20, "Gendalft");
        Warrior warrior = new Warrior(150, 25, "Arigon");

        Enemy enemy = new Enemy(50, 7);
        Zombie enemy1 = new Zombie(30,3,60);
        Troll enemy2 = new Troll(200,20,90);

        heroes.add(legolas);
        heroes.add(warrior);
        heroes.add(mage);
        enemies.add(enemy);
        enemies.add(enemy1);
        enemies.add(enemy2);

        for (Hero hero : heroes) {
            int i = new Random().nextInt(0, enemies.size());
            hero.attackEnemy(enemies.get(i));
            if (enemies.get(i).isAlive()) {
                System.out.println(enemies.get(i) + "  еще живой");
                }else {
                enemies.remove(enemies.get(i));
            }

            }

        }

}
