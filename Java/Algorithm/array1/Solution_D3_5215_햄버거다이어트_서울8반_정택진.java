package array1;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution_D3_5215_햄버거다이어트_서울8반_정택진{
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream("res/input_d3_5215.txt"));
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		int[] mat_point, mat_cal;
		
		
		String line = br.readLine();
		int num_test = Integer.parseInt(line);
		int num_material, lim_cal, cur_point, cur_cal, max_point;
		
		for (int n = 0; n < num_test; n++) {
			max_point = 0;
			try {
				line = br.readLine();
				num_material = Integer.parseInt(line.split(" ")[0]);
				lim_cal = Integer.parseInt(line.split(" ")[1]);
				mat_point = new int[num_material];
				mat_cal = new int[num_material];
				
				for(int i = 0; i < num_material; i ++) {
					line = br.readLine();
					mat_point[i] = Integer.parseInt(line.split(" ")[0]);
					mat_cal[i] = Integer.parseInt(line.split(" ")[1]);
				}
				
				for(int i = 0; i < num_material; i++) {
					cur_cal = mat_cal[i];
					cur_point = 0;
					for(int j = i + 1; j < num_material; j++) {
						if((cur_cal + mat_cal[j]) <= 1000)
							cur_point = cur_point + Cal(mat_cal, mat_point, j, (cur_cal+ mat_cal[j]));
						if(max_point < cur_point)
							max_point = cur_point;
					}
					if(max_point == 0)
						max_point = mat_point[i];
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
			
			bw.write("#" + (n+1) + " " + max_point + "\n");
		}
		
		bw.flush();
		bw.close();
	}
	
	public static int Cal(int[] cals, int[] points, int index, int cur_cal) {
		int next_cal;
		int next_point = 0, max_point = 0;
		
		for(int i = index + 1; i < cals.length; i ++) {
			next_cal = cur_cal + cals[i];
			if(next_cal <= 1000) {
				next_point = Cal(cals, points, i, next_cal);
			}
			if(max_point < next_point )
				max_point = next_point;
		}

		return max_point + points[index];
	}
}