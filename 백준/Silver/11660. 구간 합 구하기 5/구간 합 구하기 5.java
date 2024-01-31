import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
//        int n = 4;
//        int m = 3;
        int[][] arr = new int[n][n];
//        int[][] arr = {{1,2,3,4},{2,3,4,5},{3,4,5,6},{4,5,6,7}};
        int[][] dp = new int[n+1][n+1];

        for(int i = 0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[1][1] = arr[0][0];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp.length; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1] + arr[i-1][j-1] - dp[i-1][j-1];
//                System.out.print(dp[i][j] + " ");
            }
//            System.out.println();
        }
//        System.out.println();


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