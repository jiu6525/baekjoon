//package org.example.jiu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    static BufferedReader br;
    static int n = 12, m = 6,ans;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    static char[][] arr = new char[n][m];
    static boolean flag;
    public static void main(String[] args) throws NumberFormatException, IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        while(true){
            flag = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(arr[i][j] != '.'){
                        bfs(i, j, arr[i][j]);
                    }
                }
            }
            if(!flag){
                break;
            }

            ans++;
            for (int i = n-1; i >= 0; i--) {
                for (int j = 0; j < m; j++) {
                    if(arr[i][j] == '.'){
                        swap(i,j);
                    }
                }
            }
        }
//        print(arr);
        System.out.println(ans);
    }

    private static void swap(int x, int y) {
        for (int i = x-1; i >= 0; i--) {
            if(arr[i][y] != '.'){
                arr[x][y] = arr[i][y];
                arr[i][y] = '.';
                break;
            }
        }
    }


    private static void bfs(int x,int y,char w) {
        boolean[][] v = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        Queue<int[]> lst = new LinkedList<>();
        q.offer(new int[]{x,y});
        lst.offer(new int[]{x,y});
        v[x][y] = true;

        while(!q.isEmpty()){
            int[] p = q.poll();
            int dx = p[0];
            int dy = p[1];

            for (int[] d : dir) {
                int nx = dx + d[0];
                int ny = dy + d[1];
                if(nx < 0 || nx>=n || ny<0|| ny >= m){
                    continue;
                }

                if(arr[nx][ny] != w || v[nx][ny]){
                    continue;
                }

                v[nx][ny] = true;
                q.offer(new int[] {nx,ny});
                lst.offer(new int[]{nx,ny});
            }
        }
        if(lst.size() >= 4){
            while (!lst.isEmpty()){
                int[] p = lst.poll();
                int ex = p[0];
                int ey = p[1];
                arr[ex][ey] = '.';
            }
            flag = true;
        }
    }

    private static void print(char[][] arr) {
        for (char[] lst : arr) {
            System.out.println(Arrays.toString(lst));
        }
    }
}