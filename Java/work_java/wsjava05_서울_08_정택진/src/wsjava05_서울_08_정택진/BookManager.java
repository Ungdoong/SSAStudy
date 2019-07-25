package wsjava05_서울_08_정택진;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BookManager implements IBookManager{
	private ArrayList<Book> books = new ArrayList<Book>();
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public boolean run() throws Exception {
		System.out.println("<<Book Manager>>");
		System.out.println("1. 책 추가");
		System.out.println("2. 책 검색");
		System.out.println("3. 모든 도서의 금액 합계");
		System.out.println("4. 모든 도서의 금액 평균");
		System.out.println("5. 샘플 데이터로 초기화");
		char ch=br.readLine().charAt(0);
		
		System.out.println();
		switch(ch) {
		case '1':
			addBook();
			break;
		case '2':
			searchBook();
			break;
		case '3':
			sum();
			break;
		case '4':
			average();
			break;
		case '5':
			init();
			break;
		case 'q':
			return false;
		default:
			System.out.println("잘못된 입력 ^__^");
			break;
		}
		
		return true;
	}
	
	public void addBook() throws Exception {
		System.out.println("<<책 추가>>");
		System.out.println("1. Magazine");
		System.out.println("2. Novel");
		if(br.readLine().charAt(0) == '1')
			add(new Magazine());
		else if(br.readLine().charAt(0) == '2')
			add(new Novel());
		else
			System.out.println("잘못 입력하셨습니다. 초기화면으로 돌아갑니다.");
		System.out.println();
	}
	
	public void searchBook() throws Exception{
		System.out.println("<<책 검색>>");
		System.out.println("1. 전체 검색");
		System.out.println("2. Isbn으로 검색");
		System.out.println("3. Title로 검색");
		System.out.println("4. Novel만 검색");
		System.out.println("5. Magazine만 검색");
		System.out.println("6. 출판사로 검색");
		System.out.println("7. 가격으로 검색");
		char ch=br.readLine().charAt(0);
		
		System.out.println();
		switch(ch) {
		case '1':
			allBooks();
			break;
		case '2':
			System.out.print("-Isbn: ");
			findByIsbn(br.readLine());
			break;
		case '3':
			System.out.print("-Title: ");
			findByTitle(br.readLine());
			break;
		case '4':
			findNovel();
			break;
		case '5':
			findMagazine();
			break;
		case '6':
			System.out.print("-Publisher: ");
			findPublisher(br.readLine());
			break;
		case '7':
			System.out.print("-Price: ");
			findByPrice(Integer.parseInt(br.readLine()));
			break;
		default:
			System.out.println("잘못 입력하셨습니다. 초기화면으로..");	
		}
		System.out.println();
	}
	
	public void init() {
		books.add(new Magazine("21424", "Java Pro", "김하나", "Jaen.kr", 15000, "Java 기본 문법", 2019, 07));
		books.add(new Novel("35355", "분석설계", "소나무", "Jaen.kr", 30000, "SW 모델링", "Novel"));
		books.add(new Magazine("35535", "Java World", "편집부", "java.com", 7000, "첫걸음", 2018, 2));
		System.out.println("샘플 책 3개를 추가하였습니다.");
		System.out.println();
	}
	
	@Override
	public void add(Book book) {
		books.add(book);
		System.out.println("목록에 추가했습니다.");
	}

	@Override
	public Book[] allBooks() {
		Book[] book_arr = new Book[books.size()];
		
		if(books.size() != 0) {
			for(int i=0; i<books.size(); i++) {
				book_arr[i] = books.get(i);
				System.out.println(books.get(i).toString());
			}
			return book_arr;
		}else {
			System.out.println("책이 없습니다.");
			return null;
		}
	}

	@Override
	public Book findByIsbn(String isbn) {
		for(Book b :books) {
			if(b.getIsbn().equals(isbn)) {
				System.out.println(b.toString());
				return b;
			}
		}
		System.out.println("해당 책을 찾을 수 없습니다.");
		return null;
	}

	@Override
	public Book findByTitle(String title) {
		for(Book b :books) {
			if(b.getTitle().equals(title)) {
				System.out.println(b.toString());
				return b;
			}
		}
		System.out.println("해당 책을 찾을 수 없습니다.");
		return null;
	}

	@Override
	public Book[] findNovel() {
		ArrayList<Book> novels = new ArrayList<Book>();
		for(Book b :books) {
			if(b instanceof Novel) {
				System.out.println(b.toString());
				novels.add(b);
			}
		}
		if(novels.size() == 0)
			System.out.println("Novel 책이 없습니다.");
		else {
			Book[] novels_arr=new Book[novels.size()];
			for(int i=0; i<novels.size(); i++)
				novels_arr[i] = novels.get(i);
			return novels_arr;
		}
		return null;
	}

	@Override
	public Book[] findMagazine() {
		ArrayList<Book> magazines = new ArrayList<Book>();
		for(Book b :books) {
			if(b instanceof Magazine) {
				System.out.println(b.toString());
				magazines.add(b);
			}
		}
		if(magazines.size() == 0)
			System.out.println("Magazine 책이 없습니다.");
		else {
			Book[] magazines_arr=new Book[magazines.size()];
			for(int i=0; i<magazines.size(); i++)
				magazines_arr[i] = magazines.get(i);
			return magazines_arr;
		}
		return null;
	}

	@Override
	public Book[] findPublisher(String publisher) {
		ArrayList<Book> tmp_books = new ArrayList<Book>();
		for(Book b :books) {
			if(b.getPublisher().equals(publisher)) {
				System.out.println(b.toString());
				tmp_books.add(b);
			}
		}
		if(tmp_books.size() == 0)
			System.out.println("해당 출판사의 책이 없습니다.");
		else {
			Book[] arr=new Book[tmp_books.size()];
			for(int i=0; i<tmp_books.size(); i++)
				arr[i] = tmp_books.get(i);
			return arr;
		}
		return null;
	}

	@Override
	public Book[] findByPrice(int price) {
		ArrayList<Book> list = new ArrayList<Book>();
		for(Book b :books) {
			if(b.getPrice() <= price) {
				System.out.println(b.toString());
				list.add(b);
			}
		}
		if(list.size() == 0)
			System.out.println("입력하신 가격보다 낮거나 같은 책이 없습니다.");
		else {
			Book[] arr=new Book[list.size()];
			for(int i=0; i<list.size(); i++)
				arr[i] = list.get(i);
			return arr;
		}
		return null;
	}

	@Override
	public int sum() {
		int sum=0;
		for(Book b :books)
			sum += b.getPrice();
		System.out.println("금액 합계는 <"+sum+">원 입니다.");
		System.out.println();
		return sum;
	}

	@Override
	public double average() {
		int sum=0;
		double aver;
		for(Book b :books)
			sum += b.getPrice();
		aver = sum/books.size();
		System.out.println("금액 평균은 <"+aver+">원 입니다.");
		System.out.println();
		return aver;
	}
}
