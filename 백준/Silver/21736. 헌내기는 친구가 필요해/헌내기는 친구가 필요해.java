import java.io.BufferedReader;
    import java.io.FileInputStream;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.Arrays;
    import java.util.HashMap;
    import java.util.Map;
    import java.util.StringTokenizer;


    public class Main {

        public static BufferedReader br;
        public static int n, m;
        public static int[][] arr;
        public static boolean[][] flag;
        public static int ans = 0;
        public static int dx;
        public static int dy;
        public static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
        public static StringTokenizer st;
        public static void main(String[] args) throws IOException {
            //System.setIn(new FileInputStream("src/input.txt"));
            br = new BufferedReader(new InputStreamReader(System.in));
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            arr = new int[n][m];
            flag = new boolean[n][m];

            for (int i = 0; i < n; i++) {
                char[] cArr = br.readLine().toCharArray();
                for (int j = 0; j < m; j++) {
                    arr[i][j] = cArr[j];
                    if(arr[i][j] == 73){
                        dx = i;
                        dy = j;
                    }
                }
//                System.out.println(Arrays.toString(arr[i]));
            }

            flag[dx][dy] = true;

            for (int i = 0; i < 4; i++) {
                int nx = dx + dir[i][0];
                int ny = dy + dir[i][1];

                dfs(nx,ny);
            }

            System.out.println(ans == 0 ? "TT" : ans);
        }


        private static void dfs(int x, int y) {
            if (x < 0 || x >= n || y < 0 || y >= m || flag[x][y]) {
                return;
            }

            if(arr[x][y] == 88){
                return;
            }

            if(arr[x][y] == 80){
                ans++;
            }

            flag[x][y] = true;

            dfs(x, y + 1);
            dfs(x - 1, y);
            dfs(x, y - 1);
            dfs(x + 1, y);
        }
    }