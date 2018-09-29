package 第12次;

import java.util.Scanner;

public class 最小差值 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N, result, a, b;
		int[] array;
		
		N = sc.nextInt();
		array = new int [N];
		
		for (int i = 0; i < N; i++) {
			array[i] = sc.nextInt();
		}
		
		result = array[1] - array[0];
		if (result < 0) {
			result *= -1;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (array[i] - array[j] < result && i != j && array[i] - array[j] >= 0) {
					a = array[i];
					b = array[j];
					result = a - b;
				}		
			}
		}
		
		System.out.println(result);
	}
}
