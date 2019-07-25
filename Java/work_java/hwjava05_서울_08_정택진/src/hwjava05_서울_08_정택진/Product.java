package hwjava05_서울_08_정택진;

public class Product {
	private int id;
	private String name;
	private int price;
	private int count;
	
	public Product(int id, String name, int price, int count) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.count = count;
	}
	
	public int getId() { return this.id; }
	public String getName() { return this.name; }
	public int getPrice() { return this.price; }
	public int getCount() { return this.count; }
	
	public String toString() {
		return "제품번호: "+id+" / 제품명: "+name+" / 가격: "+price+" / 재고수량: "+count;
	}
}