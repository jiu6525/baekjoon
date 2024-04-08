import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static int r,c,n;
    static int cnt,cnt2,ans;
    static int[][] arr;
    static boolean[][] v;
    static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("src/jiu/Main.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr = new int[r][c];
        v = new boolean[r][c];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int nx = Integer.parseInt(st.nextToken());
            int ny = Integer.parseInt(st.nextToken());
            for (int j = x; j < nx; j++) {
                for (int k = y; k < ny; k++) {
                    arr[k][j] = 1;
                }
            }
        }


        List<Integer> ansList = new ArrayList<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(!v[i][j] && arr[i][j] == 0){
                    cnt = 0;
                    dfs(i,j);
                    ansList.add(cnt);
                }
            }
        }
//        print();
        Collections.sort(ansList);
        System.out.println(ansList.size());
        for (Integer a : ansList) {
            System.out.print(a + " ");
        }

    }

    private static void dfs(int x, int y) {
        cnt++;
        v[x][y] = true;

        for (int[] d : dir) {
            int dx = x + d[0];
            int dy = y + d[1];
            if(check(dx,dy) && !v[dx][dy] && arr[dx][dy] == 0){
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