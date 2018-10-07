package 第8次;

import java.util.Scanner;

public class 最大波动 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t, waveMax, wave;
		int[] price;
		
		t = sc.nextInt();
		price = new int[t];
		
		for (int i = 0; i < t; i++) {
			price[i] = sc.nextInt();
		}
		
		if (price[1] - price[0] > 0) {
			waveMax = price[1] - price[0];
		} else {
			waveMax = - price[1] + price[0];
		}
		
		for (int i = 2; i < t; i++) {
			wave = price[i] - price[i - 1];
			if (wave > 0 && wave > waveMax)
				waveMax = wave;
			else if ((-wave) > waveMax)
				waveMax = (-wave);
		}
		
		System.out.println(waveMax);
		
		sc.close();
	}
}
