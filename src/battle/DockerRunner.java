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

import static battle.BattleGround.battle;

public class DockerRunner {
    public static void main(String[] args) {

        List<Enemy> enemies = new ArrayList<>();
        List<Hero> heroes = new ArrayList<>();
        boolean isHeroFlag = false;
        boolean isEnemyFlag = false;


        for (String arg : args) {
            if (arg.equalsIgnoreCase("--herotype")) {
                isHeroFlag = true;
            } else if (isHeroFlag) {
                // Если будет False то идет следующий парамент -- или что то другое
                if (arg.startsWith("--")) {
                    isHeroFlag = false; // Отключаем режим сбора героев
                } else {
                    heroes.add(createHero(arg));
                }
            }
            if(arg.equalsIgnoreCase("--enemytype")) {
                isEnemyFlag = true;
            } else if (isEnemyFlag) {
                // Если будет False то идет следующий парамент -- или что то другое
                if (arg.startsWith("--")) {
                    isEnemyFlag = false; // Отключаем режим сбора героев
                } else {
                    enemies.add(createEnemy(arg));
                }
            }
        }

        battle(heroes, enemies);
    }

    private static Enemy createEnemy(String enemyType) {
        Enemy enemy = null;
        if(enemyType.equalsIgnoreCase("Enemy")) {
            enemy = new Enemy(50, 7,50);
        } else if (enemyType.equalsIgnoreCase("Zombie")) {
            enemy = new Zombie(30,3,50);
        } else {
            enemy = new Troll(200,20,50);
        }
        return enemy;
    }

    public static Hero createHero(String heroType) {
        Hero hero = null;
        if(heroType.equalsIgnoreCase("Mag")) {
            hero = new Mage(200, 20, "Gendalf",1);
        }
        else if(heroType.equalsIgnoreCase("Archer")) {
            hero =new Archer(200, 15, "Legolas",40);
        }
        else {
            hero = new Warrior(200, 25, "Arigon",20);
        }
        return hero;
    }
}
