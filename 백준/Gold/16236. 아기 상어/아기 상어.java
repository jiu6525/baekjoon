//package org.example.jiu;//package jiu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 좌표와 몇번째인지 확인할 depth 필요
public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n, shark = 2,fish, x, y, cnt = 0, ans = 0;
    static int[][] arr;
    static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        fish = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 9){
                    x = i;
                    y = j;
                    arr[i][j] = 0;
                }else if(arr[i][j] > 0){
                    fish++;
                }
            }
        }

        int tmp;
        while(fish != 0){
            tmp = fish;
            bfs();
            if(tmp == fish){
                break;
            }
        }
        System.out.println(ans);
    }

    private static void bfs() {
        boolean[][] v = new boolean[n][n];
        Queue<int[]> q = new LinkedList<int[]>();
        q.add(new int[] {x,y,1});
        v[x][y] = true;

        int n_x = -1;
        int n_y = -1;
        int n_depth = Integer.MAX_VALUE;

        while(!q.isEmpty()){
            int[] p = q.poll();
            int dx = p[0];
            int dy = p[1];

            int depth = p[2];

            if(n_depth < depth){
                break;
            }
            for (int[] d : dir) {
                int nx = dx + d[0];
                int ny = dy + d[1];

                if(nx>=0&&nx<n&&ny>=0&&ny<n&&!v[nx][ny]&&arr[nx][ny]<=shark) {
                    if(arr[nx][ny] > 0 && shark>arr[nx][ny]){
                        if(n_x == -1){
                            n_x = nx;
                            n_y = ny;
                            n_depth = depth;
                        } else{
                            if(n_x > nx){
                                n_x = nx;
                                n_y = ny;
                            }else if(n_x == nx){
                                if(n_y > ny){
                                    n_x = nx;
                                    n_y = ny;
                                }
                            }
                        }
                    }
                    v[nx][ny] = true;
                    q.add(new int[]{nx,ny, depth+1});
                }
            }
        }
        if(n_x != -1){
            arr[n_x][n_y] = 0;
            ans += n_depth;
            fish--;
            x = n_x;
            y = n_y;
            cnt++;
            if(cnt == shark){
                cnt = 0;
                shark++;
            }
        }


    }

//        print(arr);

    private static void print(int[][] arr) {
        for (int[] lst : arr) {
            System.out.println(Arrays.toString(lst));
        }
        System.out.println();
    }
}