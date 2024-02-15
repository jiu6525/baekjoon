//package org.example.jiu;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//이길때
//비길때
//질때
// team idx
public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int sum;
    static int[] win, draw, lose;
    static boolean flag;
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/jiu/Main.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            flag = false;
            sum = 0;
            win = new int[6];
            draw = new int[6];
            lose = new int[6];
            for (int j = 0; j < 6; j++) {
                win[j] = Integer.parseInt(st.nextToken());
                draw[j] = Integer.parseInt(st.nextToken());
                lose[j] = Integer.parseInt(st.nextToken());
                int num = win[j] + draw[j] + lose[j];
                if(num != 5){
                    break;
                }
                sum += num;
            }

            flag = false;
            if(sum == 30) {
                dfs(0,1 ,0);
            }

//            print(win);
//            print(draw);
//            print(lose);
            System.out.print((flag ? 1:0) + " ");
        }


    }
    //    경우의 수 A : B,C,D,E,F | B : C,D,E,F | C : D,E,F | D : E,F | E : F
    private static void dfs(int team, int idx, int cnt) {
        if(flag) {
            return;
        }
        if(cnt == 15) {
//            System.out.println(Arrays.toString(win));
//            System.out.println(Arrays.toString(draw));
//            System.out.println(Arrays.toString(lose));
            flag = true;
            return;
        }

        if(cnt == 5) {
            team++;
            idx = 1;
        }else if(cnt == 9) {
            team++;
            idx = 1;
        }else if(cnt == 12) {
            team++;
            idx = 1;
        }else if(cnt == 14) {
            team++;
            idx = 1;
        }

//        재귀돌면서 첫째 팀이 0보다 작거나 두번재 팀이 0보다 작은경우 리턴


//        첫팀이 이길때

        if(win[team]>0 && lose[team+idx] > 0 ) {
            win[team]--;
            lose[team+idx]--;
            dfs(team,idx+1,cnt+1);
            win[team]++;
            lose[team+idx]++;
        }

//        두번째 팀이 이길때

        if(win[team+idx]>0 && lose[team] > 0 ) {
            win[team+idx]--;
            lose[team]--;
            dfs(team, idx + 1, cnt + 1);
            win[team+idx]++;
            lose[team]++;
        }

//        무승부

        if(draw[team+idx]>0 && draw[team] > 0 ) {
            draw[team]--;
            draw[team+idx]--;
            dfs(team, idx + 1, cnt + 1);
            draw[team]++;
            draw[team+idx]++;
        }



    }
    private static void print(int[] board) {
        for (int i : board) {
            System.out.print(i);
        }
        System.out.println();

    }
}