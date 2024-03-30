import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static BufferedReader br;
    static StringTokenizer st;
    static int[][] arr,tmp;
    static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    static int t,n,r,c,ans;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());

            arr = new int[r][c];
            tmp = new int[r][c];

            ans = Integer.MAX_VALUE;

            for (int i = 0; i < r; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < c; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            per();
//        print(arr);
        System.out.printf("#%d %d\n",tc,ans);
        }
    }

    private static void per() {
        int[] lst = new int[c];
        for (int i = 0; i < c; i++) {
            lst[i] = i;
        }
        int[] sel = new int[n];

        rc(0,lst,sel);
    }

    private static void rc(int k,int[] lst, int[] sel) {
        if(k == sel.length){
            makeArr();
            game(sel);
            ans = Math.min(ans, tmpCount());
            return;
        }

        for (int i = 0; i < lst.length; i++) {
            sel[k] = lst[i];
            rc(k+1,lst,sel);
        }
    }

    private static int tmpCount() {
        int cnt = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(tmp[i][j] !=0){
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private static void makeArr() {
        for (int i = 0; i < r; i++) {
            tmp[i] = arr[i].clone();
        }
    }

    private static void game(int[] sel) {
        for (int i = 0; i < sel.length; i++) {  // 가로 확인
            for (int j = 0; j < r; j++) {
                if(tmp[j][sel[i]] != 0){
                    cal(j,sel[i],tmp[j][sel[i]]);
                    break;
                }
            }
        }
    }

    private static void cal(int x, int y, int power) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x,y,power});
        tmp[x][y] = 0;

        while(!q.isEmpty()){
            int[] p = q.poll();
            int dx = p[0];
            int dy = p[1];
            int dPower = p[2];

            for (int i = 1; i < dPower; i++) {
                for (int[] d : dir) {
                        int nx = dx + d[0] * i;
                        int ny = dy + d[1] * i;

                        if (!check(nx, ny)) {
                            continue;
                        }

                        if(tmp[nx][ny] != 0){
                            q.offer(new int[]{nx,ny,tmp[nx][ny]});
                            tmp[nx][ny] = 0;
                        }
                }
            }
        }
        fallDown();
    }

    private static void fallDown() {
        for (int i = 0; i < c; i++) {
            for (int j = r-1; j >= 0; j--) {
                if(tmp[j][i] == 0){
                    for (int k = j-1; k >= 0 ; k--) {
                        if(tmp[k][i] != 0){
                            tmp[j][i] = tmp[k][i];
                            tmp[k][i] = 0;
                            break;
                        }
                    }
                }
            }
        }
    }

    private static boolean check(int nx, int ny) {
        if(nx < 0 || nx >= r || ny < 0 || ny >= c){
            return false;
        }
        if(arr[nx][ny] == 0){
            return false;
        }
        return true;
    }

    private static void print(int[][] arr) {
        for (int[] lst : arr) {
            System.out.println(Arrays.toString(lst));
        }
        System.out.println();
    }
}