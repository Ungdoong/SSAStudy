package algorithm;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class KMP {
	public static int[] getPi(String pattern) {
		int M=pattern.length();
		int j=0;
		char[] p=pattern.toCharArray();
		int[] pi=new int[M];
		
		for(int i=1; i<M; i++) {
			while(j>0 && p[i] != p[j])
				j = pi[j-1];
			if(p[i] == p[j])
				pi[i] = ++j;
		}
		System.out.println(Arrays.toString(pi));
		return pi;
	}
	public static int kmp(String str, String pattern) {
		int result=0;
		int[] pi=getPi(pattern);
		int N=str.length();
		int M=pattern.length();
		int j=0;
		char[] s=str.toCharArray();
		char[] p=pattern.toCharArray();
		
		for(int i=0; i<N; i++) {
			while(j>0 && s[i]!=p[j])
				j=pi[j-1];
			if(s[i] == p[j]) {
				if(j==M-1) {
					result++;
					j=pi[j];
				}else	j++;
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_d3_1213.txt"));
//		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1; tc<=1; tc++) {
//			br.readLine();
//			String pattern=br.readLine();
//			String str=br.readLine();
			String pattern="abcab";
			String str="abcadabcabdefabcafabcabe";
			System.out.println("#"+tc+" "+kmp(str, pattern));
		}
	}
}