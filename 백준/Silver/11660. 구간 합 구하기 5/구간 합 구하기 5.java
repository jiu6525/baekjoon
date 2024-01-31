import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] dp = new int[n+1][n+1];

        for (int i = 1; i < dp.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < dp.length; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1] + Integer.parseInt(st.nextToken()) - dp[i-1][j-1];
            }
        }

        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            System.out.println(dp[c][d] - dp[c][b-1] - dp[a-1][d] + dp[a-1][b-1]);
        }
    }
}