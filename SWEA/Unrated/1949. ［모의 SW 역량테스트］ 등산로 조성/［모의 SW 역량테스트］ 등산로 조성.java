import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static BufferedReader br;
    static StringTokenizer st;
    static int[][] arr;
    static boolean[][] v;
    static int t,n,k,max_val, ans;
    static int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};

    public static void main(String[] args) throws NumberFormatException, IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            arr = new int[n][n];
            ans = 0;
            max_val = 0;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    max_val = Math.max(max_val,arr[i][j]);
                }

            }
            v = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(arr[i][j] == max_val) {
                        v[i][j] = true;
                        dfs(i,j,max_val,true,1);
                        v[i][j] = false;
                    }
                }
            }
//            print();

            System.out.printf("#%d %d\n",tc,ans);
        }
    }

    private static void dfs(int x, int y, int max, boolean flag, int m) {
        ans = Math.max(ans,  m);

        for (int[] d : dir) {
            int nx = x + d[0];
            int ny = y + d[1];
            if(nx<0 || nx>=n || ny<0 || ny>=n) {
                continue;
            }

            if(v[nx][ny]) {
                continue;
            }

            if(arr[nx][ny] < max) {
                v[nx][ny] = true;
                dfs(nx,ny,arr[nx][ny],flag,m+1);
                v[nx][ny] = false;
            }else {
                if(flag) {
                    if (arr[nx][ny] - k < max) {
                        v[nx][ny] = true;
                        dfs(nx, ny, max - 1, !flag, m + 1);
                        v[nx][ny] = false;
                    }
                }
            }

        }

    }

    private static void print() {
        for (int[] lst : arr) {
            System.out.println(Arrays.toString(lst));
        }

    }
}