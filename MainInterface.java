package tbrCode;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MainInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your character's name: ");
        String playerName = scanner.nextLine();
        MainCharacter player = new MainCharacter(playerName);

        System.out.println("Welcome to the RPG Game, " + player.getName() + "!");
        System.out.println("Your journey begins...");

        List<EnemyType> enemyTypes = new ArrayList<>();
        enemyTypes.add(EnemyType.GOBLIN);
        enemyTypes.add(EnemyType.ORC);
        enemyTypes.add(EnemyType.DRAGON);

        while (player.isAlive()) {
            EnemyType randomEnemyType = enemyTypes.get(new Random().nextInt(enemyTypes.size()));
            Enemy enemy = new Enemy(randomEnemyType);

            System.out.println("A wild " + enemy.getName() + " appears!");

            while (enemy.isAlive() && player.isAlive()) {
                System.out.println(player.getName() + "'s HP: " + player.getHP());
                System.out.println(enemy.getName() + "'s HP: " + enemy.getHP());

                System.out.print("Do you want to attack (a) or flee (f)? ");
                String choice = scanner.nextLine();

                if (choice.equals("a")) {
                    int playerDamage = new Random().nextInt(player.getAttack()) + 1;
                    int monsterDamage = new Random().nextInt(enemy.getAttack()) + 1;

                    enemy.takeDamage(playerDamage);
                    player.takeDamage(monsterDamage);

                    System.out.println(player.getName() + " dealt " + playerDamage + " damage to " + enemy.getName());
                    System.out.println(enemy.getName() + " dealt " + monsterDamage + " damage to " + player.getName());
                } else if (choice.equals("f")) {
                    System.out.println(player.getName() + " fled from battle.");
                    break;
                } else {
                    System.out.println("Invalid choice!");
                }
            }

            if (!player.isAlive()) {
                System.out.println(player.getName() + " has been defeated.");
                break;
            }
        }

        System.out.println("Game over.");
        scanner.close();
    }
}
