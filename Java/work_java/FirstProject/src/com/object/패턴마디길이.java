package com.object;
import java.util.Scanner;
public class 패턴마디길이 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        for(int tc=0;tc<T;tc++) {
            String s=sc.next();
            int cnt=0;
            char s2[]=new char[s.length()];
            Loop:for(int i=1;i<s.length();i++) {
                    s2[0]=s.charAt(0);
                    cnt=0;
                if(s.charAt(i)!=s.charAt(0)) {
                    s2[i]=s.charAt(i);
                }
                else {
                    for(int j=0;j<s2.length;j++) {
                        System.out.print(s2[j]);
                        if(s2[j]==s.charAt(j)) {
                                if(s2[j]=='\0') {
                                    break;
                                }else cnt++;
                            }else {
                                s2[j]=s.charAt(i);
                                continue Loop;                        
                        }
                    
                        
                    }
                }
            }
            System.out.println(cnt);}
        
    }
}