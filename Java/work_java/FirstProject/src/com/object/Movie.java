package com.object;

public class Movie {
	//field
	String title;
	String director;
	int grade;
	String genre;
	String summary;
	
	//method
	void movieInfo() {
		System.out.println("title:"+title);
		System.out.println("director:"+director);
		System.out.println("grade:"+grade);
		System.out.println("genre:"+genre);
		System.out.println("summary:"+summary);
	}
}