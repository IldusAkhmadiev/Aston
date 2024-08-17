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

        Archer legolas = new Archer(200, 15, "Legolas",40);
        Mage mage = new Mage(200, 20, "Gendalf",1);
        Warrior warrior = new Warrior(200, 25, "Arigon",20);

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
            if (hero instanceof Mage)  {
                if(hero.canUseAbility()) {
                    hero.useAbility(heroes.get(i));
                }
            }else {
                if(hero.canUseAbility()) {
                    hero.useAbility(enemies.get(i));
                }
            }

            if (enemies.get(i).isAlive()) {
                System.out.println(enemies.get(i) + "  еще живой осталось хп :" + enemies.get(i).getHealth());
            } else {
                System.out.println("Умер " + enemies.get(i));
                enemies.remove(enemies.get(i));
            }
        }
        for (Enemy enemy3 : enemies) {
            int i = new Random().nextInt(0, enemies.size());
            enemy3.attackEnemy(heroes.get(i));
            if(heroes.get(i).isAlive()) {
                System.out.println(heroes.get(i) + "  еще живой осталось хп :" + heroes.get(i).getHealth());
            } else  {
                System.out.println(" Умер " + heroes.get(i));
                heroes.remove(heroes.get(i));
            }
        }


    }

}
