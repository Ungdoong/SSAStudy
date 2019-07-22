package array2;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Babygin2 {
    public static final int N=6;
    public static int[] n=new int[N];
    public static int[] a=new int[N];
    public static int caseCount;
    
    public static boolean permutation(int count) {
        //재귀 호출 이용
        if(count==N) {
            for(int i=0;i<N;i++) {
                for(int j=i+1;j<N;j++) {
                    if(a[i]==a[j])	return false;
                }
            }
            caseCount++;
            System.out.println(Arrays.toString(a));
            return true; // 멈추는 코딩
        }
        for(int i=1;i<=N;i++) {
            a[count]=n[i];
            permutation(count+1);
        }
        return false;
    }
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        System.setIn(new FileInputStream("res/input_babygin.txt"));
        Scanner sc = new Scanner(System.in);
        int T=sc.nextInt();
        
        for(int tc=1;tc<=T;tc++) {
            for(int i=0;i<N;i++) {
                n[i]=sc.nextInt();

            }
            System.out.println("#"+tc+" "+permutation(0));
        }
        
        sc.close();
    }
}