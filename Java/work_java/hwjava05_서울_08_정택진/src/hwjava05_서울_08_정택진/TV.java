package hwjava05_서울_08_정택진;

public class TV extends Product{
	private int inch;
	private String type;
	
	public TV(int id, String name, int price, int count, int inch, String type) {
		super(id, name, price, count);
		this.inch = inch;
		this.type = type;
	}
	
	public String toString() {
		return super.toString()+" / 인치: "+inch+" / 타입: "+type;
	}
}
