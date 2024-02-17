//package org.example.jiu;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n,m,range,cnt,ans;
    static int[][] arr,tmp;
    static int[] sel,test,archer = new int[3];
    static boolean[] v;
    static Queue<int[]> q;
    static List<int[]> enemy;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/jiu/Main.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        range = Integer.parseInt(st.nextToken());
        arr = new int[n+1][m];
        q = new LinkedList<>();
        for (int i = 1; i < n+1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[n-i+1][j] = Integer.parseInt(st.nextToken());
            }
        }

        test = new int[m];
        for (int i = 0; i < m; i++) {
            test[i] = i;
        }
        sel = new int[3];

        rc(0,0);
//        dfs(0,0);
//        sel = new int[][] {{0,0},{0,1},{0,2}};



//        print(arr);
        System.out.println(ans);
    }

    private static void getSolve(int[] archer, int[][] map){
//        System.out.println(Arrays.toString(archer));
        Queue<int[]> enemy = new LinkedList<>();
        int cnt = 0;
        int depth = 1;
        while(true){
            if(depth >= n+1) {
                break;
            }
            for(int t = 0; t<3; t++){
                int dx = depth-1;
                int dy = archer[t];

                int min = Integer.MAX_VALUE;
                int ex = -1;
                int ey = -1;

                for (int i = dx+1; i < n+1; i++) {
                    for (int j = 0; j < m; j++) {
                        if(map[i][j] == 1){
                            int r = Math.abs(dx-i) + Math.abs(dy-j);
                            if(r <= range){         // 적과 궁수의 거리가 범위보다 작거나 같다면
                                if(r < min){
                                    min = r;
                                    ex = i;
                                    ey = j;
                                }else if(r == min){   // 가장 왼쪽 부터 제거
                                    if(ey > j){
                                        ex = i;
                                        ey = j;
                                    }
                                }
                            }
                        }
                    }
                }
                if(ex != -1 && ey != -1){
//                    System.out.printf("%d %d\n",ex,ey);
                    enemy.add(new int[] {ex,ey});
                }
            }
            while(!enemy.isEmpty()){
                int[] p = enemy.poll();
                int px = p[0];
                int py = p[1];

                if(map[px][py] == 1){
                    map[px][py] = 0;
                    cnt++;
                }
            }
            depth++;
        }
        ans = Math.max(ans , cnt);
    }

    private static int[][] copyArr(int[][] arr) {
        tmp = new int[n+1][m];
        for (int i = 0; i < n+1; i++) {
            tmp[i] = arr[i].clone();
        }

//        for (int[] ints : arr) {
//            System.out.println(Arrays.toString(ints));
//        }

        return tmp;
    }

    private static void rc(int idx, int k) {
        if(k == sel.length) {
            getSolve(sel,copyArr(arr));
            return;
        }

        if(idx == test.length) {
            return;
        }

        sel[k] = test[idx];
        rc(idx+1, k+1);
        rc(idx+1, k);

    }
    private static void print(int[][] map) {
        for (int[] lst : map) {
            System.out.println(Arrays.toString(lst));
        }
    }
}

//0 0 0 0 0
//0 0 0 0 0
//0 0 0 0 0
//1 1 1 1 1
//0 0 0 0 0

//0 0 0 0 0
//1 1 1 1 1
//0 0 0 0 0
//0 0 0 0 0
//0 0 0 0 0