package ¯ʯ��˵;

/**
 * ¯ʯ��˵��Ҫ��������
 * Ӣ����
* @author ZhenLEE
* @version 1.0
*/
public class Hero {
	private int hp;
	private Weapon weapon; 
	private int hasSummon; //����Ӣ�۳����ĸ�λ�������; 0-6 ��Ӧ���ϵ� 1-7;
							 //����ӵ�λ��ֵΪ1��û�е�λ��Ϊ��
	
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
	 * Ӣ���ܵ������ĺ���
	 * @param damage	Ӣ���ܵ����˺�ֵ
	 * @return	Ӣ��ʣ���Ѫ��
	 */
	public int beAttacked(int damage) {
		hp -= damage;
		
		return hp;
	}
	
	/**
	 * �ٻ�һ����ӣ��������һ
	 */
	public void callOutSummon() {
		hasSummon += 1;
	}
	
	/**
	 * һ������������������һ
	 */
	public void deadSummon() {
		hasSummon -= 1;
	}
	
	/**
	 * װ������
	 * @param attack �����Ĺ�����
	 * @param endurance	�������;ö�
	 */
	public void equip(int attack, int endurance) {
		weapon.setAttack(attack);
		weapon.setEndurance(endurance);
	}
	
	/**
	 * Ӣ�۹�����ӵĺ���
	 * @param a ����������Ӷ���
	 * @return ��������������������1�����򷵻�0
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
	 * Ӣ�۹���Ӣ�۵ĺ���
	 * @param a ��������Ӣ�۶���
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
