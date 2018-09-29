package 第十次;

import java.util.Scanner;

public class 学生排队 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n, t;
		int[] queue;
		int location, movement;
		
		n = sc.nextInt();
		t = sc.nextInt();
		queue = new int[n + 1];
		
		for (int i = 1; i <= n; i++) {
			queue[i] = i;
		}
		
		for (int i = 0; i < t; i++) {
			location = sc.nextInt();
			movement = sc.nextInt();
			
			for (int k = 1; k < n; k++) {
				if (queue[k] == location) {
					location = k;
					break;
				}
			}
			
			int tag = queue[location];
			
			if (movement > 0) {
				for (int j = location; j < location + movement; j++) {
					queue[j] = queue[j + 1];
				}
				queue[location + movement] = tag;
			} else if (movement == 0) {
				continue;
			} else	{
				for (int j = location; j > location + movement; j--) {
					queue[j] = queue[j - 1];
				}
				queue[location + movement] = tag;
			}

		}
		
		for (int i = 1; i < n; i++) {
			System.out.print(queue[i] + " ");
		}
		
		System.out.println(queue[n]);
	}
}
