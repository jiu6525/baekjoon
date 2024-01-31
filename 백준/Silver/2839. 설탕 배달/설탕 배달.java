import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] arr = {3,5};
	static int ans = 0;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException{
		int n = Integer.parseInt(br.readLine());
//		int n = 11;
		check(n,0);
		System.out.println(ans);
	}

	static void check(int n, int idx) {
		if(n%5 == 0) {
			ans = idx+n/5;
			return;
		}
		if(n<0) {
			ans = -1;
			return;
		}
		
		check(n-3,idx+1);
	}
}