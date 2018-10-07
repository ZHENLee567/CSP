package 炉石传说;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HeathStone {
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
					attack(p1, p2, toAttack, position, p1Summon, p2Summon);
				} else {
					attack(p2, p1, toAttack, position, p2Summon, p1Summon);
				}
			} else if (tag.charAt(0) == 'w') {

				int weaponAttack, endurance;

				weaponAttack = sc.nextInt();
				endurance = sc.nextInt();

				if (whosTurn % 2 == 0)
					p1.equip(weaponAttack, endurance);
				else
					p2.equip(weaponAttack, endurance);
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
		printPlayer(p1, p1Summon);

		// 输出p2信息
		printPlayer(p2, p2Summon);

		sc.close();
	}
	
	/**
	 * 炉石传说中的攻击函数
	 * @param p1  进行回合的玩家
	 * @param p2  另一个玩家
	 * @param toAttack 被攻击角色的位置
	 * @param position 攻击者的位置
	 * @param p1Summon 进行回合玩家的随从
	 * @param p2Summon 另一个玩家的随从
	 */
	public static void attack(Hero p1, Hero p2, int toAttack, int position, List<Summon> p1Summon, List<Summon> p2Summon) {
		if (toAttack == 0 && position == 0)
			// 英雄攻击英雄
			p1.attackHero(p2);
		else if (toAttack == 0) {
			// 随从攻击英雄
			p1Summon.get(position - 1).attackHero(p2);
		} else if (position == 0) {
			// 英雄攻击随从
			if (p1.attackSummon(p2Summon.get(toAttack - 1)) == 1) {
				p2Summon.remove(toAttack - 1);
				p2.deadSummon();
			}
		} else {
			// 随从攻击随从
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
	}
	
	/**
	 * 输出玩家信息的函数
	 * @param p 要输出玩家信息的英雄
	 * @param pSummon 要输出玩家信息的随从
	 */
	public static void printPlayer(Hero p, List<Summon> pSummon) {
		System.out.println(p.getHp());
		System.out.print(p.getHasSummon());
		for (int i = 0; i < p.getHasSummon(); i++)
			System.out.print(" " + pSummon.get(i).getHp());
		System.out.println();
	}
}
