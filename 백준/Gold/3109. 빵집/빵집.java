//package org.example.jiu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m, ans;
    static char[][] arr;
    static boolean flag = false;
    static int[] dir = {-1, 0, 1};

    public static void main(String[] args) throws IOException {
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
            dfs(i, 0);
            if(flag){
                ans++;
                flag = false;
            }
        }
        System.out.println(ans);
    }

    public static void dfs(int x, int y) {
        if (y == m - 1) {
            flag = true;
            return;
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
            dfs(nx, ny);
            if (flag) {
                return;
            }
        }
    }
}