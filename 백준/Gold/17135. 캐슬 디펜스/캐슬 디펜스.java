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
    static StringTokenizer st;
    static int n, m, range, ans;
    static int[][] arr;
    static int[] sel, archer;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/jiu/Main.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        range = Integer.parseInt(st.nextToken());
//      궁수의 위치를 맨 위로 설정, 탐색하기 편하니깐
        arr = new int[n+1][m];
        ans = 0;
        for (int i = 1; i < n+1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[n-i+1][j] = Integer.parseInt(st.nextToken());
            }
        }

        makeComb();
        comb(0,0);
//        print(arr);
        System.out.println(ans);
    }

    private static void makeComb() {
        sel = new int[m];
        for (int i = 0; i < m; i++) {
            sel[i] = i;
        }
        archer = new int[3];
    }

    private static void comb(int idx, int k) {
        if(k == 3){
            game(archer,getMap());
            return;
        }

        if(idx == m){
            return;
        }

        archer[k] = sel[idx];
        comb(idx+1,k+1);
        comb(idx+1,k);
    }

    private static void game(int[] archer, int[][] map) {
        Queue<int[]> enemy = new LinkedList<>();
        int cnt = 0;
        int depth = 1;

        while(true){    // 깊이 만큼 탐색후 종료
            if(depth >= n+1){
                break;
            }

            for (int t = 0; t < 3; t++) {   // 궁수의 위치의 선택지 만큼 반복
                int dx = depth-1;     // 현재 궁수의 위치
                int dy = archer[t];   // 조합으로 얻은 궁수의 위치
                int min_val = Integer.MAX_VALUE;
                int nx = -1, ny = -1;

                for (int i = dx+1; i < n+1; i++) {
                    for (int j = 0; j < m; j++) {
                        if(map[i][j] == 1){
//                          격자판의 두 위치 (r1, c1), (r2, c2)의 거리는 |r1-r2| + |c1-c2|
                            int distance = Math.abs(dx-i) + Math.abs(dy-j);
                            if(distance <= range){      // 사정거리
                                if(distance < min_val){
                                    min_val = distance;
                                    nx = i;
                                    ny = j;
                                }else if(distance == min_val){  //거리가 같다면 가장 왼쪽 부터 적 제거
                                    if(ny > j){
                                        nx = i;
                                        ny = j;
                                    }
                                }
                            }
                        }
                    }
                }
                if(nx != -1 && ny != -1){       // 제거 할수 있는 적 판별
                    enemy.add(new int[]{nx,ny});
                    }
                }
                while(!enemy.isEmpty()){
                    int[] p = enemy.poll();
                    int x = p[0];
                    int y = p[1];
                    if(map[x][y] == 1){     //동시공격이 가능 함으로 조건 체크
                        map[x][y] = 0;
                        cnt++;
                    }
                }
            depth++;    // 궁수 위치 증가
        }
        ans = Math.max(cnt , ans);
    }

    private static int[][] getMap() {       // 궁수 위치에 대한 맵을 표시해야 하기 때문에 arr 에 대한 깊은복사
        int[][] tmp = new int[n+1][m];
        for (int i = 0; i < n+1; i++) {
            tmp[i] = arr[i].clone();
        }
        return tmp;
    }

    private static void print(int[][] arr) {
        for (int[] lst : arr) {
            System.out.println(Arrays.toString(lst));
        }
    }
}