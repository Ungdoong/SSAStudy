package hwjava04_서울_8반_정택진;

public class TV {
	private int proID;
	private String model;
	private int price;
	private int count;
	private int inch;
	private String type;
	
	public TV(int proID, String model, int price, int count, int inch, String type) {
		super();
		this.proID = proID;
		this.model = model;
		this.price = price;
		this.count = count;
		this.inch = inch;
		this.type = type;
	}
	
	public String toString() {
		return proID+"\t"+model+"\t"+price+"\t"+count
				+"\t"+inch+"\t"+type;
	}
}