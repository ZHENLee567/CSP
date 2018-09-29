package 第9次;

import java.util.Scanner;
 
public class 工资计算{
 
	public static void main(String[] args) {
		int salaryRange[] = { 3500, 3500 + 1500, 3500 + 4500, 3500 + 9000,
				3500 + 35000, 3500 + 55000, 3500 + 80000 };
		int taxRate[] = { 3, 10, 20, 25, 30, 35, 45 };		//为了避免浮点型运算
		int SIZE = 7;// 分段
		int range[] = new int[SIZE];
		int t, s;
 
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
 
		// 计算各种收入范围
		range[0] = salaryRange[0];
		for (int i = 1; i < SIZE; i++) {
			range[i] = range[i - 1] + (salaryRange[i] - salaryRange[i - 1])
					- (salaryRange[i] - salaryRange[i - 1]) * taxRate[i - 1]
					/ 100;
		}
		// 计算收入范围
		int i;
		for (i = 0; i < SIZE; i++)
			if (t <= range[i])
				break;
 
		// 计算税前工资
		if (i == 0)
			s = t;
		else {
			s = salaryRange[i - 1] + (t - range[i - 1]) * 100
					/ (100 - taxRate[i - 1]);
		}
 
		// 输出结果
		System.out.println(s);
 
		sc.close();
	}
 
}
