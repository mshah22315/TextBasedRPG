package tbrCode;

public class MainCharacter {
	private String name;
	private int hp;
	private int attack;
	private int xp;
    private int level;

    public MainCharacter(String name) {
    	this.name = name;
	    this.hp = 100;
	    this.attack = 10;
	    this.xp = 0;
      this.level = 1;
    }

	public String getName() {
		return name;
	}

	public int getHP() {
	    return hp;
	}

	public int getAttack() {
	    return attack;
	}
	
	public int getXP() {
        return xp;
    }

    public int getLevel() {
        return level;
    }


	public void takeDamage(int damage) {
	    hp -= damage;
	    if (hp < 0) {
	    	hp = 0;
	    }
	}
	
	public void gainXP(int xp) {
        this.xp += xp;
        if (this.xp >= level * 100) {
            levelUp();
        }
    }
	
	private void levelUp() {
        level++;
        hp += 20; // Increase health when leveling up
        attack += 5; // Increase attack when leveling up
        System.out.println("Level up! " + name + " is now level " + level + "!");
    }

	public boolean isAlive() {
	    return hp > 0;
	}
}
