package com.object;

public class MovieTest {

	public static void main(String[] args) {
		Movie mv = new Movie();
		
		mv.director="정택진";
		mv.genre="공포";
		mv.grade=19;
		mv.summary="무서웡";
		mv.title="대추나무사람걸렸네";
		
		mv.movieInfo();
	}
}