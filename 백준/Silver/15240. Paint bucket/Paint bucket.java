import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import javax.swing.Spring;


public class Main {

    static class Node{
        int x,y,c,t;

        public Node(int x, int y, int c,int t) {
            this.x = x;
            this.y = y;
            this.c = c;
            this.t = t;
        }

        public Node() {}
    }
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

        bfs(new Node(x,y,c,arr[x][y]));
        for (int[] lst : arr) {
            for (int i : lst) {
                sb.append(i);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs(Node node) {
        Queue<Node> q = new LinkedList<>();
        v[node.x][node.y] = true;
        arr[node.x][node.y] = node.c;
        q.offer(node);

        while(!q.isEmpty()){
            Node p = q.poll();
            int dx = p.x;
            int dy = p.y;

            for (int[] d : dir) {
                int nx = dx + d[0];
                int ny = dy + d[1];

                if(check(nx,ny) && !v[nx][ny] && arr[nx][ny] == p.t){
                    v[nx][ny] = true;
                    arr[nx][ny] = p.c;
                    q.offer(new Node(nx,ny,p.c,p.t));
                }
            }
        }
    }


    private static boolean check(int nx, int ny) {
        if(nx >= 0 && nx < n && ny >= 0 && ny < m){
            return true;
        }
        return false;
    }
}