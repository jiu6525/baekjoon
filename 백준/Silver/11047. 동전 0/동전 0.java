import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int n,m,ans;
    static int[] coins;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

//        System.out.println(Arrays.toString(coins));
        for (int i = n-1; i >= 0; i--) {
            if(m>=coins[i]){
                ans += m/coins[i];
                m = m%coins[i];
            }
        }
        System.out.println(ans);
    }
}