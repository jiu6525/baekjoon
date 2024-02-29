//package jiu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n;
    static int[][] arr;
    static boolean[] v;
    static int[] user;
    static int ans;

    public static void main(String[] args) throws NumberFormatException, IOException {
        //System.setIn(new FileInputStream("src/jiu/Main.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        v = new boolean[10];
        user = new int[10];
        arr = new int[n + 1][10];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        // 4번 타자 1번 픽
        v[4] = true; 
        user[4] = 1;

        ans = 0;
        rc(2);
        System.out.println(ans);
    }

    // 순열
    public static void rc(int k) {      // 1번(4) 가
        if (k == 10) {
//            System.out.println(Arrays.toString(user));
            game();
            return;
        }

        for (int i = 1; i <= 9; i++) {
            if (v[i]) {
                continue;
            }
            v[i] = true;
            user[i] = k;
            rc(k + 1);
            v[i] = false;
        }
    }

    private static void game() {
        int turn = 0;
        int score = 0;

        for (int i = 1; i < arr.length; i++) {
            int out = 0;
            int[] inning = arr[i];

            int sum = 0;
            int cnt = 0;
            while (out < 3) {
                int user = Main.user[++turn];
                turn %= 9;
                int res = inning[user];
                if (res == 0) {
                    out++;
                } else {
                    if (res == 4) {
                        cnt += cal(sum, 1,0);
                        sum = 0;
                    } else {
                        sum = sum << res | 1<<(res-1);
                        if (sum >= 8) {
                            cnt += cal(sum, 0,1);
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

    private static int cal(int sum, int cnt, int type) {
        if(type == 0){
            return cnt + Integer.bitCount(sum & 0b111);
        }
        return Integer.bitCount(sum & -1 << 3);
    }

}
 