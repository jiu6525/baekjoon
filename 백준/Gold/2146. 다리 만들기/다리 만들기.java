import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n,cnt = 2;
    static int[][] arr;
    static int ans = Integer.MAX_VALUE;
    static boolean[][] v;
    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        numLandCheck();
        searchLand();
        System.out.println(ans);
    }

    private static void searchLand() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(arr[i][j] != 0){
                    v = new boolean[n][n];
                    bfs(i,j);
                }
            }
        }
    }

    private static void numLandCheck() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(arr[i][j] == 1){
                    if(dfs(i,j)){
                        cnt += 1;
                    }
                }
            }
        }
    }

    private static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x,y,0});

        int land = arr[x][y];
        v[x][y] = true;
        while(!q.isEmpty()){
            int[] num = q.poll();
            int dx = num[0];
            int dy = num[1];
            for (int[] d : dir) {
                int nx = dx + d[0];
                int ny = dy + d[1];
                if(nx>=0 && nx<n && ny>=0 && ny<n && !v[nx][ny] && arr[nx][ny] != land){
                    v[nx][ny] = true;
                    if(arr[nx][ny] == 0){
                        q.offer(new int[] {nx,ny,num[2] + 1});
                    }else{
                        ans = Math.min(ans, num[2]);
                    }
                }
            }
        }
    }

    private static boolean dfs(int x, int y) {
        if(x<0 || x>=n || y<0 || y>=n){
            return false;
        }

        if(arr[x][y] == 1){
            arr[x][y] = cnt;

            dfs(x-1,y);
            dfs(x,y-1);
            dfs(x+1,y);
            dfs(x,y+1);

            return true;
        }
        return false;
    }

    private static void print(int[][] arr) {
        for (int[] lst : arr) {
            System.out.println(Arrays.toString(lst));
        }
    }
}

//[2, 2, 2, 0, 0, 0, 0, 3, 3, 3]
//[2, 2, 2, 2, 0, 0, 0, 0, 3, 3]
//[2, 0, 2, 2, 0, 0, 0, 0, 3, 3]
//[0, 0, 2, 2, 2, 0, 0, 0, 0, 3]
//[0, 0, 0, 2, 0, 0, 0, 0, 0, 3]
//[0, 0, 0, 0, 0, 0, 0, 0, 0, 3]
//[0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
//[0, 0, 0, 0, 4, 4, 0, 0, 0, 0]
//[0, 0, 0, 0, 4, 4, 4, 0, 0, 0]
//[0, 0, 0, 0, 0, 0, 0, 0, 0, 0]