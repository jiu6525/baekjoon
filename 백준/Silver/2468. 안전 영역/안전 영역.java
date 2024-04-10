import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n,cnt,ans;
    static int h;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    static int[][] arr;
    static boolean[][] v;
    static boolean flag;
    public static void main(String[] args) throws NumberFormatException, IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        h = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                h = Math.max(h, arr[i][j]);
            }
        }

//        print();
        solve(h);
        System.out.println(ans);
    }

    private static void solve(int h) {
        for (int i = 0; i <= h; i++) {
            v = new boolean[n][n];
            cnt = 0;
            cal(i);
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if(!v[j][k] && arr[j][k] != 0){
                        cnt++;
                        dfs(j,k);
                    }
                }
            }
            ans = Math.max(cnt, ans);
        }
    }

    private static void cal(int x) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(arr[i][j] == x){
                    arr[i][j] = 0;
                }
            }
        }
    }

    private static void dfs(int x, int y) {
        v[x][y] = true;

        for (int[] d : dir) {
            int nx = x + d[0];
            int ny = y + d[1];

            if(check(nx,ny) && !v[nx][ny] && arr[nx][ny] != 0){
                dfs(nx,ny);
            }
        }
    }

    private static boolean check(int nx, int ny) {
        if(nx >= 0 && nx < n && ny >= 0 && ny < n){
            return true;
        }
        return false;
    }

    private static void print() {
        for (int[] lst : arr) {
            System.out.println(Arrays.toString(lst));
        }
    }
}