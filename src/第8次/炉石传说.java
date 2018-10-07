package 第8次;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 炉石传说随从类
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
	 * 随从攻击英雄的函数
	 * 
	 * @param a 被攻击的英雄
	 * @return 返回值为被攻击英雄剩余血量
	 */
	public int attackHero(Hero a) {
		return a.beAttacked(attack);
	}

	/**
	 * 随从攻击随从的函数
	 * 
	 * @param a 随从攻击对象
	 * @return 返回一个整型，2：两个随从都死亡；-1：被攻击随从死亡；1：攻击方随从死亡；0：没有随从死亡
	 */
	public int attackSummon(Summon a) {
		a.hp -= this.attack;
		this.hp -= a.attack;

		if (a.hp <= 0 && this.hp <= 0)
			return 2; // 两个随从都死亡
		if (a.hp <= 0)
			return -1; // 被攻击随从死亡
		else if (this.hp <= 0)
			return 1; // 攻击方随从死亡
		else
			return 0; // 没有随从死亡
	}
};

/**
 * 炉石传说英雄类
 * 
 * @author ZhenLEE
 * @version 1.0
 */
class Hero {
	private int hp;
	private int hasSummon; // 代表英雄场上哪个位置有随从; 0-6 对应场上的 1-7;
							// 有随从的位置值为1，没有的位置为零

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
	 * 英雄被随从攻击
	 * 
	 * @param damage 英雄受到的伤害
	 * @return 英雄剩余的生命值
	 */
	public int beAttacked(int damage) {
		hp -= damage;

		return hp;
	}

	/**
	 * 英雄召唤一个随从，随从数加一
	 */
	public void callOutSummon() {
		hasSummon += 1;
	}

	/**
	 * 随从死亡，场上随从数减一
	 */
	public void deadSummon() {
		hasSummon -= 1;
	}
};

public class 炉石传说 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Hero p1 = new Hero();
		Hero p2 = new Hero();
		List<Summon> p1Summon = new ArrayList<Summon>();
		List<Summon> p2Summon = new ArrayList<Summon>();
		String tag;
		int n, health, attack, position, toAttack;
		int whosTurn; // 用于判断是谁的回合

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
							// 双方随从死亡
							p1.deadSummon();
							p1Summon.remove(position - 1);
							p2.deadSummon();
							p2Summon.remove(toAttack - 1);
						} else if (flag == 1) {
							// 攻击方随从死亡
							p1.deadSummon();
							p1Summon.remove(position - 1);
						} else if (flag == -1) {
							// 被攻击随从死亡
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
							// 双方随从死亡
							p1.deadSummon();
							p1Summon.remove(toAttack - 1);
							p2.deadSummon();
							p2Summon.remove(position - 1);
						} else if (flag == 1) {
							// 攻击方随从死亡
							p2.deadSummon();
							p2Summon.remove(position - 1);
						} else if (flag == -1) {
							// 被攻击随从死亡
							p1.deadSummon();
							p1Summon.remove(toAttack - 1);
						}

					}
				}
			} else {
				whosTurn++;
			}

		}

		// 输出游戏结果
		if (p1.getHp() <= 0)
			System.out.println("-1");
		else if (p2.getHp() <= 0)
			System.out.println("1");
		else
			System.out.println("0");

		// 输出p1信息
		System.out.println(p1.getHp());
		System.out.print(p1.getHasSummon());
		for (int i = 0; i < p1.getHasSummon(); i++)
			System.out.print(" " + p1Summon.get(i).getHp());
		System.out.println();

		// 输出p2信息
		System.out.println(p2.getHp());
		System.out.print(p2.getHasSummon());
		for (int i = 0; i < p2.getHasSummon(); i++)
			System.out.print(" " + p2Summon.get(i).getHp());
		System.out.println();

		sc.close();
	}
}
