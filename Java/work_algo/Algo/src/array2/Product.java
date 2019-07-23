package array2;

import java.util.Arrays;
import java.util.Scanner;
//중복순열 nPIr=n^r
public class Product {
    public static int n,r,caseCount,data[];
    public static void product(int count) {
        //재귀 호출 이용
        if(count==r) {
            caseCount++;
            System.out.println(Arrays.toString(data));
            return; // 멈추는 코딩
        }else {
            for(int i=1;i<=n;i++) {
                data[count]=i;
                product(count+1);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=6;//sc.nextInt();
        r=3;//sc.nextInt();
        data=new int[r];
        product(0);
        System.out.println(caseCount);
        sc.close();
    }

}