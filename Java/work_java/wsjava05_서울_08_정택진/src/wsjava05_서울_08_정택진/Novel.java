package wsjava05_서울_08_정택진;

public class Novel extends Book {
	String genre;
	
	public Novel() throws Exception {
		super();
		System.out.print("-genre: ");
		this.genre = br.readLine();
	}
	
	public Novel(String isbn, String title, String author, String publisher, int price, String desc, String genre) {
		super(isbn, title, author, publisher, price, desc);
		this.genre = genre;
	}
	
	public String toString() {
		return isbn+"\t| "+title+"\t| "+author+"\t| "+publisher
				+"\t| "+price+"\t| "+desc
				+"\t| "+genre;
	}
}