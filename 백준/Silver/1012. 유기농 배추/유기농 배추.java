import java.util.Scanner;

public class Main {
    static int n, m;
    static int[][] arr;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int[] answer = new int[t];
        
        for (int i0 = 0; i0 < t; i0++) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            int k = scanner.nextInt();
            
            arr = new int[50][50];
            
            for (int i1 = 0; i1 < k; i1++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                arr[x][y] = 1;
            }
            
            int result = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (dfs(i, j)) {
                        result += 1;
                    }
                }
            }
            answer[i0] = result;
        }
        
        for (int i : answer) {
            System.out.println(i);
        }
    }

    public static boolean dfs(int a, int b) {
        if (a < 0 || b < 0 || a >= n || b >= m) {
            return false;
        }
        if (arr[a][b] == 1) {
            arr[a][b] = 0;
            
            dfs(a - 1, b);
            dfs(a + 1, b);
            dfs(a, b + 1);
            dfs(a, b - 1);
            
            return true;
        }
        return false;
    }
}