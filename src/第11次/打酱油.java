package µÚ11´Î;

import java.util.Scanner;

public class ´ò½´ÓÍ {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int Seven, Four;
		int N, result;
		
		N = sc.nextInt();
		Seven = N / 50;
		N = N % 50;
		Four = N / 30;
		N = N % 30;
		result = N / 10;
		
		result += Seven * 7 + Four * 4;
		
		System.out.println(result);
		
	}
}
