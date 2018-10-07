package 炉石传说;

/**
 * 炉石传说，要用脑子玩
 * 英雄类
* @author ZhenLEE
* @version 1.0
*/
public class Hero {
	private int hp;
	private Weapon weapon; 
	private int hasSummon; //代表英雄场上哪个位置有随从; 0-6 对应场上的 1-7;
							 //有随从的位置值为1，没有的位置为零
	
	Hero() {
		hp = 30;
		hasSummon = 0;
		weapon = new Weapon(0, 0);
	}
	
	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getHasSummon() {
		return hasSummon;
	}

	public void setHasSummon(int hasSummon) {
		this.hasSummon = hasSummon;
	}

	/**
	 * 英雄受到攻击的函数
	 * @param damage	英雄受到的伤害值
	 * @return	英雄剩余的血量
	 */
	public int beAttacked(int damage) {
		hp -= damage;
		
		return hp;
	}
	
	/**
	 * 召唤一个随从，随从数加一
	 */
	public void callOutSummon() {
		hasSummon += 1;
	}
	
	/**
	 * 一个随从死亡，随从数减一
	 */
	public void deadSummon() {
		hasSummon -= 1;
	}
	
	/**
	 * 装备武器
	 * @param attack 武器的攻击力
	 * @param endurance	武器的耐久度
	 */
	public void equip(int attack, int endurance) {
		weapon.setAttack(attack);
		weapon.setEndurance(endurance);
	}
	
	/**
	 * 英雄攻击随从的函数
	 * @param a 被攻击的随从对象
	 * @return 如果攻击的随从死亡返回1，否则返回0
	 */
	public int attackSummon(Summon a) {
		
		if (weapon.getEndurance() == 0) 
			System.out.println("Cannot Attack!");
		else {
			a.setHp(a.getHp() - weapon.getAttack());
			hp -= a.getAttack();
			weapon.attack();
		}
		
		if (a.getHp() <= 0)
			return 1;
		else
			return 0;
	}
	
	/**
	 * 英雄攻击英雄的函数
	 * @param a 被攻击的英雄对象
	 */
	public void attackHero(Hero a) {
		if (weapon.getEndurance() == 0) 
			System.out.println("Cannot Attack!");
		else {
			a.hp -= weapon.getAttack();
			weapon.attack();
		}
	}
}
