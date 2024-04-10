
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n,m, cnt, ans;
    static int h;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    static int[][] arr;
    static boolean[][] v;
    static boolean flag;

    public static void main(String[] args) throws NumberFormatException, IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        v = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            char[] q = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(String.valueOf(q[j]));
            }
        }

//        print();

            for (int j = 0; j < m; j++) {
                if(!v[0][j] && arr[0][j] == 0){
                    dfs(0,j);
                }
            }

        System.out.println(flag ? "YES" : "NO");
    }

    private static void dfs(int x, int y) {
        if(x == n-1 && arr[x][y] == 0){
            flag = true;
        }
        v[x][y] = true;

        for (int[] d : dir) {
            int nx = x + d[0];
            int ny = y + d[1];

            if(check(nx,ny) && !v[nx][ny] && arr[nx][ny] == 0){
                dfs(nx,ny);
            }
        }
    }

    private static boolean check(int nx, int ny) {
        if(nx >= 0 && nx < n && ny >= 0 && ny < m){
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
