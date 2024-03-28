import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int n;
	static int[] arr,dp;
	public static void main(String[] args) throws Exception {
    	//System.setIn(new FileInputStream("src/jiu/Main.txt"));
    	br = new BufferedReader(new InputStreamReader(System.in));
    	n = Integer.parseInt(br.readLine());
    	
    	arr = new int[n];
    	dp = new int[n];
    	
    	st = new StringTokenizer(br.readLine());
    	
    	for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
    	
    	dp[0] = 1;
    	int r = dp[0];
    	
    	for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if(arr[j] > arr[i]) {
					dp[i] = Math.max(dp[i], dp[j]);
				}
			}
			
			dp[i] += 1;
			r = Math.max(r, dp[i]);

		}
    	System.out.println(r);
    	
    	//print(dp);
	}
	private static void print(int[] map) {
		System.out.println(Arrays.toString(map));
	}
}