import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n,m, cnt1, cnt2,sheep,wolf, ans;
    static int h;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
//    static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1},{-1,-1},{-1,1},{1,-1},{1,1}};
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

        ans = 0;
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

//
        dfs(x,y,c, arr[x][y]);
        print();
        System.out.println(sb);

    }

    private static void dfs(int x, int y, int c, int i) {
        v[x][y] = true;
        if(arr[x][y] != i){
            return;
        }else{
            arr[x][y] = c;
        }

        for (int[] d : dir) {
            int nx = x + d[0];
            int ny = y + d[1];

            if(check(nx,ny) && !v[nx][ny] && arr[nx][ny] == i){
                dfs(nx,ny,c,i);
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
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
    }

}