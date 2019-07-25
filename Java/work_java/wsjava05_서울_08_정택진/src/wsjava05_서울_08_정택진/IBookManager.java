package wsjava05_서울_08_정택진;

//BookManager가 구현해야 되는 11개의 메소드를 가지고 있는 인터페이스
public interface IBookManager {
	//1.데이터 입력 
	void add(Book book);
	//2.전체 데이터 검색
	Book[] allBooks();
	//3.isbn으로 검색
	Book findByIsbn(String isbn);
	//4.title 검색
	Book findByTitle(String title);
	//5.Novel 검색
	Book[] findNovel();
	//6.Magazine 검색
	Book[] findMagazine();
	//8.출판사로 검색
	Book[] findPublisher(String publisher);
	//9.가격으로 검색
	Book[] findByPrice(int price);
	//10.저장된 모든 도서의 금액 합계
	int sum();
	//11.저장된 모든 도서의 금액 평균
	double average();
}