package array1;

import java.util.Random;

public class IfTest {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int T=sc.nextInt();
		
		Random r = new Random();
		int T;
		int i = 0;
		
		while(i++ < 100) {
			T = r.nextInt(100)+1;
			if (T%2 == 0)
				System.out.println(T + " : 짝수");
			else
				System.out.println(T + " : 홀수");
		}
	}
}
