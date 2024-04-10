

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n,m, cnt1, cnt2,sheep,wolf, ans;
    static int h;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    static char[][] arr;
    static boolean[][] v;
    static boolean flag;

    public static void main(String[] args) throws NumberFormatException, IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new char[n][m];
        v = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine().toCharArray();
        }

//        print();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!v[i][j] && arr[i][j] != '#'){
                    cnt1 = 0;
                    cnt2 = 0;
                    dfs(i,j);
                    if(cnt1 != 0 || cnt2 != 0){
                        if(cnt1 >= cnt2){
                            wolf += cnt1;
                        }else{
                            sheep += cnt2;
                        }
                    }
                }
            }
        }

        System.out.println(sheep + " " + wolf);
    }

//    v - 늑대 - cnt1
//    o - 양 - cnt2

    private static void dfs(int x, int y) {
        if(arr[x][y] == 'v'){
            cnt1++;
        }else if(arr[x][y] == 'o'){
            cnt2++;
        }
        v[x][y] = true;

        for (int[] d : dir) {
            int nx = x + d[0];
            int ny = y + d[1];

            if(check(nx,ny) && !v[nx][ny] && arr[nx][ny] != '#'){
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
        for (char[] lst : arr) {
            System.out.println(Arrays.toString(lst));
        }
    }

}
