import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {
		int[] arr = new int[9];
		int sum = 0;
		for(int i = 0; i<9;i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		boolean flag = false;
		
		for (int i = 0; i < arr.length-1; i++) {
			for(int j = i+1; j< arr.length; j++) {
				if(sum-arr[i] - arr[j] == 100) {
					arr[i] = 0;
					arr[j] = 0;
					flag = true;
					break;
				}
			
				
			}
			if(flag) {
				break;
			}
		}
		int s = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] != 0) {
				System.out.println(arr[i]);
				s += arr[i];
			}
		}
//		System.out.println(s);
		

	}

}
