package array2;

import java.util.Arrays;
import java.util.Scanner;
//조열 nCr=nPr/r! 6C3=6*5*4/3*2*1=20
public class Combination {
    public static int n,r,caseCount,data[];
    
    public static void homogeneous(int before, int count) {
        //재귀 호출 이용
        if(count==r) {
            caseCount++;
            System.out.println(Arrays.toString(data));
            return; // 멈추는 코딩
        }else {
            for(int i=before;i<=n;i++) {
                data[count]=i;
                homogeneous(i+1, count+1);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        r=sc.nextInt();
        data=new int[r];
        homogeneous(1,0);
        System.out.println(caseCount);
        sc.close();
    }

}