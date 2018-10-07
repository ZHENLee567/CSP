package 炉石传说;

/**
 * 炉石传说，要用脑子玩
 * 武器类
* @author ZhenLEE
* @version 1.0
*/
public class Weapon {
	private int attack;
	private int endurance;
	
	public Weapon() {
		attack = 0;
		endurance = 0;
	}
	
	public Weapon(int attack, int endurance) {
		this.attack = attack;
		this.endurance = endurance;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getEndurance() {
		return endurance;
	}

	public void setEndurance(int endurance) {
		this.endurance = endurance;
	}
	
	/**
	 * 使用武器攻击，耐久度减一
	 */
	public void attack() {
		endurance -= 1;
	}
}
