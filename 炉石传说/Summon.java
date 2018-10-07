package ¯ʯ��˵;

/**
  * ¯ʯ��˵��Ҫ��������
  * �����
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
	 * Summon��Ĵ��ι��캯��
	 * @param hp ��ӵ�Ѫ��
	 * @param attack ��ӵĹ�����
	 * @param postion ��ӵ��ڳ�λ�� ��Χ�Ǵ�1��7
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
	 * ��ӹ���Ӣ�۵ĺ���
	 * @param a ��������Ӣ��
	 * @return ����ֵΪ������Ӣ��ʣ��Ѫ��
	 */
	public int attackHero(Hero a) {
		return a.beAttacked(attack);
	}
	
	/**
	 * ��ӹ�����ӵĺ���
	 * @param a ��ӹ�������
	 * @return ����һ�����ͣ�2��������Ӷ�������-1�����������������1�����������������0��û���������
	 */
	public int attackSummon(Summon a) {
		a.hp -= this.attack;
		this.hp -= a.attack;
		
		if (a.hp <= 0 && this.hp <= 0)
			return 2;			//������Ӷ�����
		if (a.hp <= 0) 
			return -1;			//�������������
		else if (this.hp <= 0)
			return 1;			//�������������
		else
			return 0;			//û���������
	}
}
