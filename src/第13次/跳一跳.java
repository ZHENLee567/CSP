package µÚ13´Î;

import java.util.Scanner;

public class ÌøÒ»Ìø {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int tag, temp = 0, result = 0, flag = 1;
		
		while (true) {
			
			tag = sc.nextInt();
			
			switch (tag) {
			case 1:
				result++;
				temp = 0;
				break;
			case 2:
				temp+=2;
				result+=temp;
				break;
			case 0:
				flag = 0;
				break;
			}
			
			if (flag == 0) {
				break;
			}
		}
		System.out.println(result);
		
	}
}
