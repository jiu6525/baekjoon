import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int n;
	public static void main(String[] args) throws Exception {
//    	System.setIn(new FileInputStream("src/jiu/main.txt"));
    	br = new BufferedReader(new InputStreamReader(System.in));
    	n = Integer.parseInt(br.readLine());
    	
    	int[] arr = new int[n+1];
    	
//    	0 밟지 않은경우
//    	1 한번 밟
//    	2 연속
    	
    	
    	int[][] dp = new int[n+1][3];
    	for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
    	
        
		for(int i =1; i <=n; i++) {
			dp[i][0] = Math.max(dp[i-1][1], dp[i-1][2]);
			dp[i][1] = dp[i-1][0] + arr[i];
			dp[i][2] = dp[i-1][1] + arr[i];
		}
        
//        System.out.println(Arrays.toString(dp));
		System.out.println(Math.max(dp[n][1], dp[n][2]));
        
    }
}