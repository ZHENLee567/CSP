package ��11��;

import java.util.Scanner;

public class ����Կ�׺� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N, K;	 
		int[] w, s, c; 	  // һλ��ʦҪʹ�õ�Կ�ױ�ţ� ��ʼ�Ͽε�ʱ�� �� ʱ��
		int[] used, free; // �������飬�ֱ����Ѿ��ù���Կ�׺�û���ù���
		int t = 24;		  // ģ���¼����е�ʱ��
		int useN = 0;     // ����Կ�׵ĸ���
		
		N = sc.nextInt();
		K = sc.nextInt();
		
		used = new int [N];
		free = new int [N];
		w = new int [K];
		s = new int [K];
		c = new int [K];
		
		//����Ԫ�س�ʼ��
		for (int i = 0; i < N; i++) {
			free[i] = i;
			used[i] = 0;
		}
		
		for (int i = 0; i < K; i++) {
			
			w[i] = sc.nextInt();
			s[i] = sc.nextInt();
			c[i] = sc.nextInt();
			
			c[i] = s[i] + c[i];			//�˴��� c ��Ϊ�黹ʱ�� 
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
