package wsjava05_서울_08_정택진;


public class BookTest {

	public static void main(String[] args) throws Exception {
		BookManager bm = new BookManager();
		boolean flag = true;
		while(flag)
			flag = bm.run();
	}
}