package 炉石传说;

/**
  * 炉石传说，要用脑子玩
  * 随从类
 * @author ZhenLEE
 * @version 1.0
 */
public class Summon {
	private int hp;
	private int attack;
	private int position;
	
	Summon() {
		hp = 0;
		attack = 0;
		position = 0;
	}
	
	/**
	 * Summon类的带参构造函数
	 * @param hp 随从的血量
	 * @param attack 随从的攻击力
	 * @param postion 随从的在场位置 范围是从1到7
	 */
	Summon(int hp, int attack, int postion) {
		this.hp = hp;
		this.attack = attack;
		this.position = postion;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}
	
	/**
	 * 随从攻击英雄的函数
	 * @param a 被攻击的英雄
	 * @return 返回值为被攻击英雄剩余血量
	 */
	public int attackHero(Hero a) {
		return a.beAttacked(attack);
	}
	
	/**
	 * 随从攻击随从的函数
	 * @param a 随从攻击对象
	 * @return 返回一个整型，2：两个随从都死亡；-1：被攻击随从死亡；1：攻击方随从死亡；0：没有随从死亡
	 */
	public int attackSummon(Summon a) {
		a.hp -= this.attack;
		this.hp -= a.attack;
		
		if (a.hp <= 0 && this.hp <= 0)
			return 2;			//两个随从都死亡
		if (a.hp <= 0) 
			return -1;			//被攻击随从死亡
		else if (this.hp <= 0)
			return 1;			//攻击方随从死亡
		else
			return 0;			//没有随从死亡
	}
}
