package java04_서울_8반_정택진;

public class Magazine {
	private String isbn;
	private String title;
	private String author;
	private String publisher;
	private int year;
	private int month;
	private int price;
	private String desc;
	
	public Magazine(String isbn, String title, String author, String publisher, int year, int month, int price,
			String desc) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.year = year;
		this.month = month;
		this.price = price;
		this.desc = desc;
	}



	public String toString() {
		return isbn+"\t| "+title+"\t| "+author+"\t| "+publisher
				+"\t| "+price+"\t| "+desc
				+"\t| "+year+"."+month;
	}
}