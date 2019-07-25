package hwjava05_서울_08_정택진;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ProductTest {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws Exception {
		ProductMgr pm = new ProductMgr();
		boolean flag=true;
		int id;
		
		while(flag) {
			System.out.println("<<Product 매니저>>");
			System.out.println("1. 상품 추가");
			System.out.println("2. 상품 전체 검색");
			System.out.println("3. 상품번호로 검색");
			System.out.println("4. 상품명으로 검색");
			System.out.println("5. TV만 검색");
			System.out.println("6. 냉장고만 검색");
			System.out.println("7. 상품번호로 상품삭제");
			System.out.println("8. 전체 재고 상품 금액");
			System.out.println("9. 샘플상품 자동입력");
			System.out.println("(종료는 'q'입력)");
			char ch=br.readLine().charAt(0);
			System.out.println();
			switch(ch) {
			case '1':
				addP(pm);
				break;
			case '2':
				findAll(pm);
				break;
			case '3':
				System.out.print("검색할 제품번호: ");
				id=Integer.parseInt(br.readLine());
				System.out.println(pm.findById(id).toString());
				break;
			case '4':
				System.out.print("검색할 이름: ");
				String name=br.readLine();
				findByName(pm, name);
				break;
			case '5':
				findTV(pm);
				break;
			case '6':
				findRef(pm);
				break;
			case '7':
				System.out.print("삭제할 제품번호: ");
				id=Integer.parseInt(br.readLine());
				pm.delById(id);
				break;
			case '8':
				System.out.println(pm.sum());
				break;
			case '9':
				init(pm);
				break;
			case 'q':
				flag=false;
				break;
			default:
				System.out.println("잘못 입력하셨습니다.");
				break;
			}
			System.out.println();
		}
	}
	
	public static void addP(ProductMgr pm) throws Exception {
		System.out.println("<<상품 추가>>");
		System.out.println("1. TV");
		System.out.println("2. 냉장고");
		char ch=br.readLine().charAt(0);
		switch(ch) {
		case '1':
			System.out.print("-제품번호: ");
			int id=Integer.parseInt(br.readLine());
			System.out.print("-제품명: ");
			String name=br.readLine();
			System.out.print("-가격: ");
			int price=Integer.parseInt(br.readLine());
			System.out.print("-재고수량: ");
			int count=Integer.parseInt(br.readLine());
			System.out.print("-인치: ");
			int inch=Integer.parseInt(br.readLine());
			System.out.print("-타입: ");
			String type=br.readLine();
			pm.add(new TV(id, name, price, count, inch, type));
			System.out.println("TV 제품을 추가하였습니다.");
			break;
		case '2':
			System.out.print("-제품번호: ");
			id=Integer.parseInt(br.readLine());
			System.out.print("-제품명: ");
			name=br.readLine();
			System.out.print("-가격: ");
			price=Integer.parseInt(br.readLine());
			System.out.print("-재고수량: ");
			count=Integer.parseInt(br.readLine());
			System.out.print("-인치: ");
			String size=br.readLine();
			pm.add(new Refrigerator(id, name, price, count, size));
			System.out.println("냉장고 제품을 추가하였습니다.");
			break;
		default:
			System.out.println("잘못 입력하셨습니다. 초기화면으로 돌아갑니다.");
			break;
		}
	}
	
	public static void findAll(ProductMgr pm) {
		Product[] arr=pm.findAll();
		for(int i=0; i<arr.length; i++)
			System.out.println(arr[i].toString());
	}
	
	public static void findByName(ProductMgr pm, String name) {
		Product[] arr=pm.findByName(name);
		for(Product p :arr)
			System.out.println(p.toString());
	}
	
	public static void findTV(ProductMgr pm) {
		Product[] arr=pm.findTV();
		for(Product p :arr)
			System.out.println(p.toString());
	}
	
	public static void findRef(ProductMgr pm) {
		Product[] arr=pm.findRef();
		for(Product p :arr)
			System.out.println(p.toString());
	}
	
	public static void init(ProductMgr pm) {
		TV tv= new TV(12345, "LED고해상도TV", 3200000, 1, 100, "QLED");
		Refrigerator r= new Refrigerator(4321, "미니냉장고", 120000, 1, "800L");
		pm.add(tv);
		pm.add(r);
		System.out.println("샘플 상품 2개를 입력했습니다.");
	}
}