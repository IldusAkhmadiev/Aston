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

        Archer legolas = new Archer(200, 15, "Legolas",50);
        Mage mage = new Mage(200, 20, "Gendalf",50);
        Warrior warrior = new Warrior(200, 25, "Arigon",50);

        Enemy enemy = new Enemy(100, 15);
        Zombie enemy1 = new Zombie(50,10,50);
        Troll enemy2 = new Troll(200,20,50);

        heroes.add(legolas);
        heroes.add(warrior);
        heroes.add(mage);
        enemies.add(enemy);
        enemies.add(enemy1);
        enemies.add(enemy2);

        battle(heroes, enemies);

      //  DockerRunner.main(new String[]{"--heroType", "Archer", "--enemyType", "Troll"});
    }

    public static void battle (List<Hero> heroes,List<Enemy> enemies) {
        while (heroes.size() > 0 || enemies.size() > 0) {
            if(checkWinner(heroes,enemies,true)) {
                break;
            }
            for (Hero hero : heroes) {
                if (checkWinner(heroes, enemies, false)) {
                    break;
                }
                int i = new Random().nextInt(0, enemies.size());
                hero.attackEnemy(enemies.get(i));
                if (hero instanceof Mage) {
                    if (hero.canUseAbility()) {
                        hero.useAbility(heroes.get(i));
                    }
                } else {
                    if (hero.canUseAbility()) {
                        hero.useAbility(enemies.get(i));
                    }
                }
                Enemy enemy = enemies.get(i);
                if (enemy.isAlive()) {
                    System.out.println(enemy + "  еще живой осталось хп :" + enemy.getHealth());
                } else {
                    if (enemy instanceof Zombie) {
                        if (((Zombie) enemy).canUseAbility()) {
                            ((Zombie) enemy).useAbility(enemy);
                        } else {
                            System.out.println(enemy + " умер.");
                            enemies.remove(enemies.get(i));
                        }
                    } else {
                        System.out.println(enemy + " умер.");
                        enemies.remove(enemies.get(i));
                    }
                }
            }
            for (Enemy enemy3 : enemies) {
                if(checkWinner(heroes,enemies,false)) {
                    break;
                }
                int i = new Random().nextInt(0, enemies.size());
                enemy3.attackEnemy(heroes.get(i));

                if (heroes.get(i).isAlive()) {
                    System.out.println(heroes.get(i) + "  еще живой осталось хп :" + heroes.get(i).getHealth());
                } else {
                    System.out.println(" Умер " + heroes.get(i));
                    heroes.remove(heroes.get(i));
                }
            }
        }

    }
    private static boolean checkWinner(List<Hero> heroes,List<Enemy> enemies,boolean msg) {
        if(enemies.isEmpty()) {
            if(msg) {
                System.out.println("---------------------------------------------");
                System.out.println("---------------------------------------------");
                System.out.println("Герои выиграли остались в живых : ");
                for (Hero hero : heroes) {
                    System.out.println(hero + " с " + hero.getHealth() + " хп");
                }
                System.out.println("---------------------------------------------");
                System.out.println("---------------------------------------------");
            }
            return true;
        }
        if(heroes.isEmpty()) {
            if(msg) {
                System.out.println("---------------------------------------------");
                System.out.println("---------------------------------------------");
                System.out.println("Враги выиграли остались в живых : ");
                for (Enemy enemy : enemies) {
                    System.out.println(enemy + " с " + enemy.getHealth() + " хп");
                }
                System.out.println("---------------------------------------------");
                System.out.println("---------------------------------------------");
            }
            return true;
        }
        return false;
    }
    }





