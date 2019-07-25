package wsjava05_서울_08_정택진;


public class Magazine extends Book{
	int year;
	int month;
	
	public Magazine() throws Exception {
		super();
		System.out.print("-year: ");
		this.year = Integer.parseInt(br.readLine());
		System.out.print("-month: ");
		this.month = Integer.parseInt(br.readLine());
	}
	
	public Magazine(String isbn, String title, String author, String publisher, int price, String desc, int year,
			int month) {
		super(isbn, title, author, publisher, price, desc);
		this.year = year;
		this.month = month;
	}

	public String toString() {
		return isbn+"\t| "+title+"\t| "+author+"\t| "+publisher
				+"\t| "+price+"\t| "+desc
				+"\t| "+year+"."+month;
	}
}