package 第9次;

import java.util.Scanner;

public class 中间数 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		int[] array;
		
		n = sc.nextInt();
		array = new int[n];
		
		for (int i = 0; i < n; i++) {
			array[i] = sc.nextInt();
		}
		for (int i = 1; i < n; i++)
			for (int j = 0; j < n - i; j++) {
				if (array[j] > array[j + 1]) {
					int tag = array[j];
					array[j] = array[j + 1];
					array[j + 1] = tag;
				}
			}
		
		if (n % 2 == 0) {
			int tag = array[n/2];
			int sum = 0;
			for (int i = 0; i < n; i++) {
				if (array[i] == tag)
					sum++;
			}
			if (sum % 2 == 0)
				System.out.println(array[n/2]);
			else
				System.out.println("-1");
		} else {
			int tag = array[n/2];
			int sum = 0;
			for (int i = 0; i < n; i++) {
				if (array[i] == tag)
					sum++;
			}
			if (sum % 2 == 1)
				System.out.println(array[n/2]);
			else
				System.out.println("-1");
		}
	}
}
