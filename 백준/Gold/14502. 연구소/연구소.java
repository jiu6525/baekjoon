//package org.example.jiu;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m, ans = Integer.MIN_VALUE;
    static int[][] arr,map;
    static List<int[]> z_lst;
    static int[] sel = new int[3];
    static int[] lst;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        z_lst = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 0){
                    z_lst.add(new int[]{i,j});
                }
            }
        }

//        print();
        lst = new int[z_lst.size()];
        for (int i = 0; i < z_lst.size(); i++) {
            lst[i] = i;
        }
        rc(0,0);

        System.out.println(ans);
    }

    private static void rc(int idx, int k) {
        if(k == sel.length){
            wall();
            return;
        }

        for (int i = idx; i < lst.length; i++) {
            sel[k] = lst[i];
            rc(i+1,k+1);
        }
    }

    private static void wall() {
        makeMap();
        change(1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == 2){
                    dfs(i,j);
                }
            }
        }

        ans = Math.max(ans,getAns());
        change(0);
    }

    private static void change(int k) {
        for (int i : sel) {
            int[] lst = z_lst.get(i);
            int x = lst[0];
            int y = lst[1];
            map[x][y] = k;
        }
    }

    private static void makeMap() {
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = arr[i].clone();
        }
    }

    private static int getAns() {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == 0){
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private static void dfs(int x, int y) {
        if(x<0 || x>=n || y<0 || y>=m){
            return;
        }

        if(map[x][y] == 2 || map[x][y] == 0){
            map[x][y] = 3;

            dfs(x,y+1);
            dfs(x,y-1);
            dfs(x+1,y);
            dfs(x-1,y);
        }
    }
}