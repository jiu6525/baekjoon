import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static int r,c,n;
    static int cnt1,cnt2,ans;
    static int[][] arr;
    static boolean[][] v;
    static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("src/jiu/Main.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new int[r][c];
        v = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

//        print();

        cnt1 = 0;
        ans = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(!v[i][j] && arr[i][j] == 1){
                    cnt2 = 0;
                    dfs(i,j);
                    cnt1++;
                    ans = Math.max(ans,cnt2);
                }
            }
        }

        System.out.println(cnt1);
        System.out.println(ans);
    }

    private static void dfs(int x, int y) {
        cnt2++;
        v[x][y] = true;

        for (int[] d : dir) {
            int dx = x + d[0];
            int dy = y + d[1];
            if(check(dx,dy) && !v[dx][dy] && arr[dx][dy] == 1){
                dfs(dx,dy);
            }
        }

    }

    private static boolean check(int dx, int dy) {
        if(dx>=0 && dx<r && dy>=0 && dy<c){
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