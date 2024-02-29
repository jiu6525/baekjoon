import java.io.*;
import java.util.*;

public class Main {
    static class Robot{
        int[] x;
        int[] y;

        public Robot() {
            super();
        }

        @Override
        public String toString() {
            return "Robot [x=" + Arrays.toString(x) + ", y=" + Arrays.toString(y) + "]";
        }
    }

    static BufferedReader br;
    static StringTokenizer st;
    static int n,m,t;
    static int[][] arr,map,tmp;
    static boolean[][] v;
    static int[][] dir1 = {{0,1},{-1,0},{0,-1},{1,0}};   // 반시계
    static int[][] dir2 = {{0,1},{1,0},{0,-1},{-1,0}};   // 시계
    static int d;
    static Robot rb = new Robot();
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        tmp = new int[n][m];
        map = new int[n][m];
        v = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == -1) {
                    if(rb.x == null) {
                        rb.x = new int[] {i,j};
                    }else {
                        rb.y = new int[]{i, j};
                    }
                }
                if(arr[i][j] >= 5) {
                    v[i][j] = true;
                }
            }
        }

        for (int i = 0; i < t; i++) {
            diffusion();
            circle(rb.x, dir1);
            circle(rb.y, dir2);
            updateMap(arr,tmp);
            visited();
//            print();
        }
        System.out.println(getAns()+2);
    }

    private static void updateMap(int[][] arr, int[][] tmp) {
        for (int i = 0; i < n; i++) {
            arr[i] = tmp[i].clone();
        }
    }

    private static void visited() {
        v = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(tmp[i][j] >= 5) {
                    v[i][j] = true;
                }
            }
        }
    }

    private static int getAns() {
        int cnt = 0;
        for (int[] lst : tmp) {
            cnt += Arrays.stream(lst).sum();
        }
        return cnt;
    }

    private static void circle(int[] type, int[][] dir) {
        d = 0;
        int dx = type[0] + dir[d][0];
        int dy = type[1] + dir[d][1];
        tmp[dx][dy] = 0;
        while(true){
            int nx = dx + dir[d][0];
            int ny = dy + dir[d][1];

            if(!check(nx,ny)){
                d+=1%4;
                continue;
            }

            if(nx == type[0] && ny == type[1]){
                break;
            }

            tmp[nx][ny] = arr[dx][dy];
            dx = nx;
            dy = ny;
        }
    }

    private static void diffusion() {
        updateMap(map,arr);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(v[i][j]) {
                    int cnt = possible(i,j);
                    for (int[] d : dir1) {
                        int nx = i + d[0];
                        int ny = j + d[1];
                        if(!check(nx,ny)) {
                            continue;
                        }
                        if(arr[nx][ny] == -1){
                            continue;
                        }
                        arr[nx][ny] += map[i][j]/5;
                    }
                    arr[i][j] -= (map[i][j]/5)*cnt;
                }
            }
        }
        updateMap(tmp,arr);
    }

    private static int possible(int x, int y) {
        int cnt = 0;
        for (int[] d : dir1) {
            int nx = x + d[0];
            int ny = y + d[1];

            if(!check(nx,ny)) {
                continue;
            }

            if(arr[nx][ny] == -1){
                continue;
            }
            cnt++;
        }
        return cnt;
    }
    private static boolean check(int nx, int ny) {
        if(nx<0 || nx>=n || ny<0 || ny>=m) {
            return false;
        }
        return true;
    }
    private static void print() {
        for (int[] lst : tmp) {
            System.out.println(Arrays.toString(lst));
        }
        System.out.println();
    }
}