package array1;

public class Hello {
	public static int[] data= {1,2,3,4};

	public static void main(String[] args) {
		for(int i=0; i<(1<<data.length); i++) {
			int sum=0;
			for(int j=0; j<data.length; j++) {
				if((i&(1<<j))>0) {
					System.out.print(data[j]+" ");
					sum=sum+data[j];
				}
			}
			
			System.out.println(" sum="+sum);
		}
	}
}