package hwjava05_서울_08_정택진;

import java.util.ArrayList;

public class ProductMgr {
	private ArrayList<Product> products = new ArrayList<Product>();
	
	//상품 추가
	public void add(Product p) {
		products.add(p);
	}
	//상품 전체 검색
	public Product[] findAll() {
		if(products.size() != 0) {
			Product[] arr=new Product[products.size()];
			for(int i=0; i<products.size(); i++)
				arr[i] = products.get(i);
			return arr;
		}
		else {
			System.out.println("등록된 제품이 업습니다.");
			return null;
		}
	}
	//상품번호로 검색
	public Product findById(int id) {
		for(Product p :products) {
			if(p.getId() == id)
				return p;
		}
		System.out.println("해당 제품을 찾을 수 없습니다.");
		return null;
	}
	//상품명으로 상품 검색(부분검색 가능)
	public Product[] findByName(String name) {
		ArrayList<Product> tmp_list=new ArrayList<Product>();
		for(Product p :products) {
			if(p.getName().contains(name))
				tmp_list.add(p);
		}
		
		if(tmp_list.size() != 0) {
			Product[] arr=new Product[tmp_list.size()];
			for(int i=0; i<tmp_list.size(); i++)
				arr[i] = tmp_list.get(i);
			return arr;
		}
		else {
			System.out.println("해당 이름이 들어간 제품을 찾을 수 없습니다.");
			return null;
		}
	}
	//TV정보만 검색
	public Product[] findTV() {
		ArrayList<Product> tmp_list=new ArrayList<Product>();
		for(Product p :products) {
			if(p instanceof TV)
				tmp_list.add(p);
		}
		
		if(tmp_list.size() != 0) {
			Product[] arr=new Product[tmp_list.size()];
			for(int i=0; i<tmp_list.size(); i++)
				arr[i] = tmp_list.get(i);
			return arr;
		}
		else {
			System.out.println("TV 제품이 없습니다.");
			return null;
		}
	}
	//Refrigerator만 검색
	public Product[] findRef() {
		ArrayList<Product> tmp_list=new ArrayList<Product>();
		for(Product p :products) {
			if(p instanceof Refrigerator)
				tmp_list.add(p);
		}
		
		if(tmp_list.size() != 0) {
			Product[] arr=new Product[tmp_list.size()];
			for(int i=0; i<tmp_list.size(); i++)
				arr[i] = tmp_list.get(i);
			return arr;
		}
		else {
			System.out.println("냉장고 제품이 없습니다.");
			return null;
		}
	}
	//상품번호로 삭제
	public void delById(int id) {
		for(int i=0; i<products.size(); i++) {
			if(products.get(i).getId() == id) {
				products.remove(i);
				System.out.println("해당 제품을 삭제했습니다.");
				return;
			}
		}
		System.out.println("해당 제품을 찾을 수 없습니다.");
	}
	//전체 재고 상품 금액을 구하는 기능
	public int sum() {
		int sum=0;
		for(Product p :products)
			sum+=p.getPrice()*p.getCount();
		return sum;
	}
}