package array2;

import java.util.Arrays;
import java.util.Scanner;
//순열 nPr=n*(n-1)*...*(n-r) 6P3=6*5*4=120
public class Permutation {
    public static int n,r,caseCount,data[];
    
    public static void permutation(int count) {
        if(count==r) {
            for(int i=0; i<r; i++) {
            	for(int j=i+1; j<r; j++) {
            		if(data[i]==data[j]) return;
            	}
            }
            caseCount++;
            System.out.println(Arrays.toString(data));
            return;
        }else {
            for(int i=1;i<=n;i++) {
                data[count]=i;
                permutation(count+1);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=6;//sc.nextInt();
        r=3;//sc.nextInt();
        data=new int[r];
        permutation(0);
        System.out.println(caseCount);
        sc.close();
    }

}