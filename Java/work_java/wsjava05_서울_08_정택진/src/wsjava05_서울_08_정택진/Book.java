package wsjava05_서울_08_정택진;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Book {
	protected String isbn;
	protected String title;
	protected String author;
	protected String publisher;
	protected int price;
	protected String desc;
	protected BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
	public Book() throws Exception {
		System.out.print("-isbn: ");
		this.isbn = br.readLine(); 
		System.out.print("-title: ");
		this.title = br.readLine();
		System.out.print("-author: ");
		this.author = br.readLine();
		System.out.print("-publisher: ");
		this.publisher = br.readLine();
		System.out.print("-price: ");
		this.price = Integer.parseInt(br.readLine());
		System.out.print("-desc: ");
		this.desc = br.readLine();
	}
	
	public Book(String isbn, String title, String author, String publisher, int price, String desc) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.desc = desc;
	}


	public String toString() {
		return isbn+"\t| "+title+"\t| "+author+"\t| "+publisher
				+"\t| "+price+"\t| "+desc;
	}
	
	public String getIsbn() { return isbn; }
	public String getTitle() { return title; }
	public String getPublisher() { return publisher; }
	public int getPrice() { return price; }
}