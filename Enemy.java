package tbrCode;
import java.util.Random;

public class Enemy {
    private EnemyType type;
    private String name;
    private int health;
    private int attack;

    public Enemy(EnemyType type) {
        this.type = type;
        switch (type) {
            case GOBLIN:
                name = "Goblin";
                this.health = new Random().nextInt(30) + 30;
                this.attack = new Random().nextInt(8) + 5;
                break;
            case ORC:
                name = "Orc";
                this.health = new Random().nextInt(40) + 50;
                this.attack = new Random().nextInt(10) + 7;
                break;
            case DRAGON:
                name = "Dragon";
                this.health = new Random().nextInt(50) + 70;
                this.attack = new Random().nextInt(12) + 10;
                break;
        }
    }

    public String getName() {
        return name;
    }

    public int getHP() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0;
        }
    }

    public boolean isAlive() {
        return health > 0;
    }
}
