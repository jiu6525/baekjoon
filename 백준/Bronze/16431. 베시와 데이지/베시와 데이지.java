import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import javax.swing.Spring;


public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
//    static int n,m, cnt1, cnt2,sheep,wolf, ans;
    static String ans;
    static int h;
    static int[][] dir1 = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    static int[][] dir2 = {{-1, 0}, {1, 0}, {0, 1}, {0, -1},{-1,-1},{-1,1},{1,-1},{1,1}};
    static int[][] arr;
    static boolean[][] v;
    static boolean flag;
    static List<int[]> w = new ArrayList<>();

    public static void main(String[] args) throws NumberFormatException, IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        arr = new int[1002][1002];


        ans = "";
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            w.add(new int[]{x,y});
        }

        int res1 = bfs(w.get(0), w.get(2), dir2);
        int res2 = bfs(w.get(1), w.get(2), dir1);

        ans = res1 == res2 ? "tie" : res1>res2 ? "daisy" : "bessie";
        System.out.println(ans);


    }

    private static int bfs(int[] cow, int[] jon, int[][] dir) {
        v = new boolean[1002][1002];
        Queue<int[]> q = new LinkedList<>();
        v[cow[0]][cow[1]] = true;
        q.offer(new int[]{cow[0],cow[1],1});
        while(!q.isEmpty()){
            int[] p = q.poll();
            int dx = p[0];
            int dy = p[1];

            for (int[] d : dir) {
                int nx = dx + d[0];
                int ny = dy + d[1];

                if(check(nx,ny) && !v[nx][ny]){
                    v[nx][ny] = true;
                    if(nx == jon[0] && ny == jon[1]){
                        return p[2];
                    }
                    q.offer(new int[]{nx,ny,p[2]+1});
                }

            }
        }
        return 0;
    }

    private static boolean check(int nx, int ny) {
        if(nx >= 0 && nx < 1002 && ny >= 0 && ny < 1002){
            return true;
        }
        return false;
    }
}