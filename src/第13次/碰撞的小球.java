package 第13次;

import java.util.Scanner;

public class 碰撞的小球 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] tag; // 表示小球的状态，-1 ： 向左， 1 ： 向右
		int[] position; //表示小球的位置
		int n, L, t;
		
		n = sc.nextInt();
		L = sc.nextInt();
		t = sc.nextInt();
		tag = new int [n];
		position = new int [n];
		
		for (int i = 0; i < n ; i++) {
			position[i] = sc.nextInt();
			tag[i] = 1;
		}
		
		for (int i = 0; i < t ; i++) {
			
			for (int j = 0; j < n ; j++) {
				if (position[j] == L && tag[j] == 1) {
					tag[j] = -1;
				} 
				else if (position[j] == 0 && tag[j] == -1) {
					tag[j] = 1;
				}
				for (int k = j; k < n; k++) {
					if (position[j] == position[k] && j != k) {
						tag[j] *= -1;
						tag[k] *= -1;
					}
				}
			}
			
			for (int j = 0; j < n; j++) {
				position[j] += tag[j];
			}
		}
		
		for (int i = 0; i < n ; i++) {
			System.out.print(position[i]);
			System.out.print(" ");
		}
	}
}
