package LegendBattle;

abstract class Hero {
	
	protected int health;
	protected int attack;
	protected int attackRange;
	protected int armor;
	
	public Hero() {
		health = 500;
		attack = 60;
		attackRange = 150;
		armor = 25;
	}

	public Hero(int health, int attack, int attackRange, int armor) {
		this.health = health;
		this.attack = attack;
		this.attackRange = attackRange;
		this.armor = armor;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getAttackRange() {
		return attackRange;
	}

	public void setAttackRange(int attackRange) {
		this.attackRange = attackRange;
	}

	public int getArmor() {
		return armor;
	}

	public void setArmor(int armor) {
		this.armor = armor;
	}
	
	public void move() {
		
	}
	
	public void Q() {
		
	}
	
	public void W() {
		
	}
	
	public void E() {
		
	}
	
	public void R() {
		
	}
}
