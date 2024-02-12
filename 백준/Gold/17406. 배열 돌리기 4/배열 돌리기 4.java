import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n,m,k, min = Integer.MAX_VALUE;
    static int[][] real_arr,arr, r;
    static List<int[]> lst = new ArrayList<>();
    static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    static int d = 0;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        real_arr = new int[n][m];
        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                real_arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

//        print(arr);

        r = new int[k][3];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                r[i][j] = Integer.parseInt(st.nextToken());
            }
        }


//        print(r);

        permutation(0, new int[k], new boolean[k]);

        for (int[] ls : lst) {
            reset();
            for (int l : ls) {
                rotate(r[l]);
            }
            check_sum(arr);
        }

        System.out.println(min);

    }

    private static void check_sum(int[][] arr) {
        for (int[] lst : arr) {
            int res = 0;
            for (int i : lst) {
                res += i;
            }
            min = Math.min(min,res);
        }
    }

    private static void rotate(int[] lst) {
        int r = lst[0]-1;
        int c = lst[1]-1;
        int s = lst[2];
//      (r,c,s) -> (3,4,2)
//        [r-s][c-s] ~ [r+s][c+s]
        int sx = r - s, sy = c - s;
        int ex = r + s, ey = c + s;

        int group = s;
        for (int i = 0; i < group; i++) {
            int x = sx + i;
            int y = sy + i;
            d = 0;
            int tmp = arr[x][y];
            while (d < 4) {
                int nx = x + dir[d][0];
                int ny = y + dir[d][1];
                if (nx >= sx + i && nx <= ex - i && ny >= sy + i && ny <= ey - i) {
                    arr[x][y] = arr[nx][ny];
                    x = nx;
                    y = ny;
                } else {
                    d++;
                }
            }
            arr[x][y + 1] = tmp;
        }
    }

    private static void reset() {
        for (int i = 0; i < n; i++) {
            arr[i] = real_arr[i].clone();
        }

    }

    public static void permutation(int cnt, int[] numbers, boolean[] visited) {
        if(cnt == k) {
            lst.add(numbers.clone());
            return;
        }
        for(int i=0; i<k; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            numbers[cnt] = i;
            permutation(cnt+1, numbers, visited);
            visited[i] = false;
        }
    }

    private static void print(int[][] arr) {
        for (int[] lst : arr) {
            System.out.println(Arrays.toString(lst));
        }
        System.out.println();
    }

}
//5 6 2
//1 2 3 2 5 6
//3 8 7 2 1 3
//8 2 3 1 4 5
//3 4 5 1 1 1
//9 3 2 1 4 3
//3 4 2
//4 2 1