import java.util.Scanner;
import java.io.FileInputStream;

public class Solution{
	public static void main(String args[]) throws Exception{
		//System.setIn(new FileInputStream(&quot;res/input.txt&quot;));
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();

		for(int tc = 1; tc <= T; tc++){
			System.out.print("#");
		}
	}
}