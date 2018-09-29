package 第11次;

import java.util.Scanner;

public class 公共钥匙盒 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N, K;	 
		int[] w, s, c; 	  // 一位老师要使用的钥匙编号， 开始上课的时间 和 时长
		int[] used, free; // 两个数组，分别存放已经用过的钥匙和没有用过的
		int t = 24;		  // 模拟事件进行的时间
		int useN = 0;     // 已用钥匙的个数
		
		N = sc.nextInt();
		K = sc.nextInt();
		
		used = new int [N];
		free = new int [N];
		w = new int [K];
		s = new int [K];
		c = new int [K];
		
		//数组元素初始化
		for (int i = 0; i < N; i++) {
			free[i] = i;
			used[i] = 0;
		}
		
		for (int i = 0; i < K; i++) {
			
			w[i] = sc.nextInt();
			s[i] = sc.nextInt();
			c[i] = sc.nextInt();
			
			c[i] = s[i] + c[i];			//此处将 c 改为归还时间 
		}
		
		for (int i = 0; i < t; i++) {
			
			for (int j = 0; j < K; j++) {
				
				if (s[j] == i) {
					for (int l = 0; l < N; l++) {
						if (w[j] == free[l]) {
							used[useN] = free[l];
							useN++;
							free[l] = 0;
						}
					}
				}
				else if (c[j] == i) {
					for (int l = 0; l < N; l++) {
						if (free[l] == 0) {
							free[l] = w[j];
							useN--;
							for (int o = 0; o < useN; o++) {
								if (used[o] == w[j]) {
									used[o] = used[useN];
									break;
								}
							}
							used[useN] = 0;
						}
					}
				}
				
			}
		}
	}
}
