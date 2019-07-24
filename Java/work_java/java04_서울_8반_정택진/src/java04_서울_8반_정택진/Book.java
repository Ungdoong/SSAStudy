package java04_서울_8반_정택진;

public class Book {
	private String isbn;
	private String title;
	private String author;
	private String publisher;
	
	public Book(String isbn, String title, String author, String publisher, int price, String desc) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.desc = desc;
	}

	int price;
	String desc;
	
	public String toString() {
		return isbn+"\t| "+title+"\t| "+author+"\t| "+publisher
				+"\t| "+price+"\t| "+desc;
	}
}