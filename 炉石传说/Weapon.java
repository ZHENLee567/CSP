package ¯ʯ��˵;

/**
 * ¯ʯ��˵��Ҫ��������
 * ������
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
	 * ʹ�������������;öȼ�һ
	 */
	public void attack() {
		endurance -= 1;
	}
}
