//package jiu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] players; // N번째 이닝에서 타자의 행동
    static boolean[] select; // 아래 순열에서 사용될 boolean 타입 배열
    static int[] lineUp; // 타순
    static int ans;
    static int[] binary = {0, 1, 2, 4};

 
    public static void main(String[] args) throws NumberFormatException, IOException {
    	//System.setIn(new FileInputStream("src/jiu/Main.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
 
        players = new int[N + 1][10];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 9; j++) {
                players[i][j] = Integer.parseInt(st.nextToken());
            }
        }
 
        select = new boolean[10];
        lineUp = new int[10];
 
        select[4] = true; // 4번 타자는 1번으로 고정되어있음.
        lineUp[4] = 1;
 
        ans = 0;
        perm(2);
 
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
 
    // 순열
    public static void perm(int num) {
        if (num == 10) {
//            System.out.println(Arrays.toString(lineUp));
            game();
            return;
        }
 
        for (int i = 1; i <= 9; i++) {
            if (select[i]) {
                continue;
            }
            select[i] = true;
            lineUp[i] = num;
            perm(num + 1);
            select[i] = false;
        }
    }
    
    private static void game() {
        int turn = 0;
        int score = 0;

        for (int i = 1; i < players.length; i++) {
            int out = 0;
            int[] inning = players[i];

            int sum = 0;
            int cnt = 0;
            while (out < 3) {
                int user = lineUp[++turn];
                turn %= 9;
                int res = inning[user];
                if (res == 0) {
                    out++;
                } else {
                    if (res == 4) {
                        cnt += cal(sum, 1);
                        sum = 0;
                    } else {
                        sum = sum << res | 1<<(res-1);
                        if (sum >= 8) {
                            cnt += cal(sum>>3, 0);
                    		sum = sum & 0b111;
//                            System.out.println(sum);
                        }
                    }
                }
            }

            score += cnt;
        }

        ans = Math.max(ans, score);
    }

    private static int cal(int sum, int cnt) {
    	String val = Integer.toBinaryString(sum);
    	for (int i = 0; i < val.length(); i++) {
			if(val.charAt(i) == '1') {
				cnt++;
			}
		}
//    	System.out.println(cnt);
        return cnt;
    }

}
 