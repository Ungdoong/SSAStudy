package array1;

import java.util.Arrays;
import java.util.Random;

public class ForTest {
	public static void main(String[] args) {
		int[] ia= new int[10];
		Random r = new Random();
		for (int i = 0; i < 10; i++) {
			ia[i] = r.nextInt(100) + 1;
		}
		System.out.println(Arrays.toString(ia));
		
		int sum = 0, max = 0 , min = 100;
		for(int i = 0; i < 10; i++) {
			System.out.println("ia[" + i + "] = " + ia[i]);
			if (max < ia[i]) max = ia[i];
			if (min > ia[i]) min = ia[i];
			sum += ia[i];
		}
		System.out.println("sum = " + sum +" / min = " + min + " / max = " + max);
	}
}