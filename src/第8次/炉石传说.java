package ��8��;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * ¯ʯ��˵�����
 * 
 * @author ZhenLEE
 * @version 1.0
 */
class Summon {
	private int hp;
	private int attack;
	private int position;

	Summon() {
		hp = 0;
		attack = 0;
		position = 0;
	}

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
	 * 
	 * @param a ��������Ӣ��
	 * @return ����ֵΪ������Ӣ��ʣ��Ѫ��
	 */
	public int attackHero(Hero a) {
		return a.beAttacked(attack);
	}

	/**
	 * ��ӹ�����ӵĺ���
	 * 
	 * @param a ��ӹ�������
	 * @return ����һ�����ͣ�2��������Ӷ�������-1�����������������1�����������������0��û���������
	 */
	public int attackSummon(Summon a) {
		a.hp -= this.attack;
		this.hp -= a.attack;

		if (a.hp <= 0 && this.hp <= 0)
			return 2; // ������Ӷ�����
		if (a.hp <= 0)
			return -1; // �������������
		else if (this.hp <= 0)
			return 1; // �������������
		else
			return 0; // û���������
	}
};

/**
 * ¯ʯ��˵Ӣ����
 * 
 * @author ZhenLEE
 * @version 1.0
 */
class Hero {
	private int hp;
	private int hasSummon; // ����Ӣ�۳����ĸ�λ�������; 0-6 ��Ӧ���ϵ� 1-7;
							// ����ӵ�λ��ֵΪ1��û�е�λ��Ϊ��

	Hero() {
		hp = 30;
		hasSummon = 0;

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
	 * Ӣ�۱���ӹ���
	 * 
	 * @param damage Ӣ���ܵ����˺�
	 * @return Ӣ��ʣ�������ֵ
	 */
	public int beAttacked(int damage) {
		hp -= damage;

		return hp;
	}

	/**
	 * Ӣ���ٻ�һ����ӣ��������һ
	 */
	public void callOutSummon() {
		hasSummon += 1;
	}

	/**
	 * ��������������������һ
	 */
	public void deadSummon() {
		hasSummon -= 1;
	}
};

public class ¯ʯ��˵ {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Hero p1 = new Hero();
		Hero p2 = new Hero();
		List<Summon> p1Summon = new ArrayList<Summon>();
		List<Summon> p2Summon = new ArrayList<Summon>();
		String tag;
		int n, health, attack, position, toAttack;
		int whosTurn; // �����ж���˭�Ļغ�

		n = sc.nextInt();

		whosTurn = 0;

		for (int i = 0; i < n; i++) {
			tag = sc.next();

			if (tag.charAt(0) == 's') {
				position = sc.nextInt();
				attack = sc.nextInt();
				health = sc.nextInt();

				if (whosTurn % 2 == 0) {
					p1.callOutSummon();
					Summon a = new Summon(health, attack, position);
					p1Summon.add(position - 1, a);
				} else {
					p2.callOutSummon();
					Summon a = new Summon(health, attack, position);
					p2Summon.add(position - 1, a);
				}

			} else if (tag.charAt(0) == 'a') {
				position = sc.nextInt();
				toAttack = sc.nextInt();

				if (whosTurn % 2 == 0) {
					if (toAttack == 0)
						p1Summon.get(position - 1).attackHero(p2);
					else {
						int flag = p1Summon.get(position - 1).attackSummon(p2Summon.get(toAttack - 1));

						if (flag == 2) {
							// ˫���������
							p1.deadSummon();
							p1Summon.remove(position - 1);
							p2.deadSummon();
							p2Summon.remove(toAttack - 1);
						} else if (flag == 1) {
							// �������������
							p1.deadSummon();
							p1Summon.remove(position - 1);
						} else if (flag == -1) {
							// �������������
							p2.deadSummon();
							p2Summon.remove(toAttack - 1);
						}
					}

				} else {
					if (toAttack == 0)
						p2Summon.get(position - 1).attackHero(p1);
					else {
						int flag = p2Summon.get(position - 1).attackSummon(p1Summon.get(toAttack - 1));

						if (flag == 2) {
							// ˫���������
							p1.deadSummon();
							p1Summon.remove(toAttack - 1);
							p2.deadSummon();
							p2Summon.remove(position - 1);
						} else if (flag == 1) {
							// �������������
							p2.deadSummon();
							p2Summon.remove(position - 1);
						} else if (flag == -1) {
							// �������������
							p1.deadSummon();
							p1Summon.remove(toAttack - 1);
						}

					}
				}
			} else {
				whosTurn++;
			}

		}

		// �����Ϸ���
		if (p1.getHp() <= 0)
			System.out.println("-1");
		else if (p2.getHp() <= 0)
			System.out.println("1");
		else
			System.out.println("0");

		// ���p1��Ϣ
		System.out.println(p1.getHp());
		System.out.print(p1.getHasSummon());
		for (int i = 0; i < p1.getHasSummon(); i++)
			System.out.print(" " + p1Summon.get(i).getHp());
		System.out.println();

		// ���p2��Ϣ
		System.out.println(p2.getHp());
		System.out.print(p2.getHasSummon());
		for (int i = 0; i < p2.getHasSummon(); i++)
			System.out.print(" " + p2Summon.get(i).getHp());
		System.out.println();

		sc.close();
	}
}
