import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int n,m;
    static int[][] arr = new int[100][100];
    static int s, e, ans;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken())-1;
            int h = Integer.parseInt(st.nextToken())-1;
            for (int j = w; j < w+10; j++) {
                for (int k = h; k < h+10; k++) {
                    arr[j][k] = 1;
                }
            }
        }

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if(arr[i][j] == 1){
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }
}