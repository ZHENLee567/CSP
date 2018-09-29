package 第十次;

import java.util.Scanner;

public class 分蛋糕 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n, k, sum = 0, num = 0, i;
		int[] array;
		
		n = sc.nextInt();
		k = sc.nextInt();
		array = new int[n];
		
		for (i = 0; i < n; i++) {
			array[i] = sc.nextInt();
		}
		
			i = 0;
		while (i < n) {
			if (sum < k && i < n-1) {
				sum += array[i];
				i++;

			} else if (sum < k && i == n - 1) {
				num++;
				break;
			} else	{
				num++;
				sum = 0;
			}
		}
		
		System.out.println(num);
	}
}
