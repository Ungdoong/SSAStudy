package com.inter;

public class SandwichUser {
	public static void main(String[] args) {
		Sandwich[] s = new Sandwich[3];
		String[] shrimp_mat= {"shrimp", "tomato","bacon","onion"};
		String[] sa_mat= {"shrimp","avocado","bacon","onion"};
		String[] bmt_mat= {"bacon","tomato","onion","sangchu","mayo"};
		s[0]=new Shrimp(shrimp_mat, 7000);
		s[1]=new ShrimpAvocado(sa_mat, 8000);
		s[2]=new ItalianBMT(bmt_mat, 5000);
		
		for(Sandwich sa :s) {
			System.out.println(sa.getClass().getSimpleName());
			sa.make();
			sa.price();
			System.out.println("--------------------------");
		}
	}
}