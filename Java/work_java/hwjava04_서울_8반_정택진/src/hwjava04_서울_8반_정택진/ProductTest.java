package hwjava04_서울_8반_정택진;

public class ProductTest {

	public static void main(String[] args) {
		TV tv= new TV(12345, "LED고해상도TV", 3200000, 1, 100, "LEDWide");
		Refrigerator r= new Refrigerator(4321, "미니냉장고", 120000, 1, "200x600");
		
		System.out.println(tv.toString());
		System.out.println(r.toString());
	}
}