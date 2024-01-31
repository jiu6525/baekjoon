import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int ans;
	static StringTokenizer st;
	static int[] lst;
	static int[] dp;
	public static void main(String[] args) throws NumberFormatException, IOException{
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		lst = new int[n];
		dp = new int[n+1];
		
		for(int i = 0; i<n; i++) {
			dp[i+1] = dp[i] + Integer.parseInt(st.nextToken());  
		}
		
		
		
		for(int k = 0; k<m; k++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			System.out.println(dp[b] - dp[a-1]);
		}
	}
}