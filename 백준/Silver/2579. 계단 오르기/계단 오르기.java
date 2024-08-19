import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br;
    public static StringTokenizer st;
    public static int n;
    public static int[] arr;
    public static int[] dp;
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/input.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        dp = new int[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

//        System.out.println(Arrays.toString(arr));

//        d(n-3) + f(n) + f(n-1)
//        d(n-2) + f(n)
        if(n == 1){
            dp[1] = arr[1];
        }else if(n == 2){
            dp[1] = arr[1];
            dp[2] = arr[1] + arr[2];
        } else{
            dp[1] = arr[1];
            dp[2] = arr[1] + arr[2];
            dp[3] = Math.max(arr[1] + arr[3], arr[2] + arr[3]);
        }

        for (int i = 4; i <= n; i++) {
            dp[i] = Math.max((dp[i-3] + arr[i] + arr[i-1]), dp[i-2] + arr[i]);
        }

        System.out.println(dp[n]);
    }
}