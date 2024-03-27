import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int t;
	public static void main(String[] args) throws Exception {
    	//System.setIn(new FileInputStream("src/jiu/main.txt"));
    	br = new BufferedReader(new InputStreamReader(System.in));
    	t = Integer.parseInt(br.readLine());
    	
    	
//    	1 = {1} , 2 = {1+1,2}, 3={1+1+1, 1+2, 2+1, 3}
//    	4 = 1 + 3, 2 + 2, 3 + 1
//    	4 -> 4 + 2 + 1
//    	dp[n] = dp[n-1] + dp[n-2] + dp[n-3];
        int[] dp = new int[11];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        
        for (int i = 4; i < 11; i++) {
        	dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        
    	for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(dp[n]);
		}
        
	    }
}