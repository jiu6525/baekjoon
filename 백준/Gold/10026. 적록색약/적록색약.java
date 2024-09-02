import java.io.BufferedReader;
    import java.io.FileInputStream;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.Arrays;
    import java.util.HashMap;
    import java.util.Map;


    public class Main {

        public static BufferedReader br;
        public static int n;
        public static int[][] arr;
        public static boolean[][] flag;
        public static int ans1 = 0;
        public static int ans2 = 0;
        public static void main(String[] args) throws IOException {
            //System.setIn(new FileInputStream("src/input.txt"));
            br = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine());
            arr = new int[n][n];
            flag = new boolean[n][n];

            // R - 82, B - 66, G - 71
            for (int i = 0; i < n; i++) {
                char[] cArr = br.readLine().toCharArray();
                for (int j = 0; j < n; j++) {
                    arr[i][j] = cArr[j];
                }
            }

            ans1 = cal();

            flag = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(arr[i][j] == 82){
                        arr[i][j] = 71;
                    }
                }
            }

            ans2 = cal();


            System.out.println(ans1 + " " + ans2);
        }

        private static int cal() {
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!flag[i][j]) {
                        count++;
                        dfs(i, j, arr[i][j]);
                    }
                }
            }
            return count;
        }

        private static void dfs(int x, int y, int num) {
            if (x < 0 || x >= n || y < 0 || y >= n || flag[x][y] || arr[x][y] != num) {
                return;
            }

            flag[x][y] = true;

            dfs(x, y + 1, num);
            dfs(x - 1, y, num);
            dfs(x, y - 1, num);
            dfs(x + 1, y, num);

        }
    }