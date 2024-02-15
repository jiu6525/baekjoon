//package jiu;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n, m, ans;
    static char[][] arr;
//    static boolean flag = false;
    static int[] dir = {-1, 0, 1};  // 오른쪽 위 대각선, 오른쪽, 오른쪽 아래 대각선

    public static void main(String[] args) throws IOException {
    	//System.setIn(new FileInputStream("src/jiu/Main.txt"));
    	br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new char[n][m];
        ans = 0;
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            if(dfs(i, 0)) {
            	ans++;
            }
        }
        System.out.println(ans);
    }

    public static boolean dfs(int x, int y) {
        if (y == m - 1) {
            return true;
        }

        for (int i = 0; i < dir.length; i++) {
            int nx = x + dir[i];
            int ny = y + 1;
            if (nx < 0 || nx >= n) {
                continue;
            }
            if(arr[nx][ny] == 'x'){
                continue;
            }
            arr[nx][ny] = 'x';
            if(dfs(nx, ny)) {
            	return true;
            }
        }
		return false;
    }
}