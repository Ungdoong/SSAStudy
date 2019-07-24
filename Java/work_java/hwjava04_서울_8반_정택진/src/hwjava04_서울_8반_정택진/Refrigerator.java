package hwjava04_서울_8반_정택진;

public class Refrigerator {
	private int proID;
	private String model;
	private int price;
	private int count;
	private String size;
		
	public Refrigerator(int proID, String model, int price, int count, String size) {
		super();
		this.proID = proID;
		this.model = model;
		this.price = price;
		this.count = count;
		this.size = size;
	}


	public String toString() {
		return proID+"\t"+model+"\t"+price+"\t"+count
				+"\t"+size;
	}
}