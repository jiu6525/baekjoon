import java.io.*;
import java.util.*;

//중복 순열
//문제 이해가 안되서 힌트찬스,;
//설명 그대로 풀면되는 문제
public class Solution {
    static BufferedReader br;
    static StringTokenizer st;
    static int t,n;
    static int[][] arr;
    static int[] color,sel;
    static int ans;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n][n];
            color = new int[n];
            sel = new int[n];
            ans = Integer.MAX_VALUE;
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                color[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            rc(0);
            System.out.printf("#%d %d\n",tc,ans);
        }
    }

    private static void rc(int k) {
        if (k == n) {
//            System.out.println(Arrays.toString(sel));
            if(check()){        // 인접하지 않고 색이 다른경우만 확인
                int change = 0;
                for (int i = 0; i < n; i++) {
                    if (color[i] != sel[i]) {       // 색변경
                        change++;
                    }
                }
                ans = Math.min(ans, change);
            }
            return;
        }

//      최대 사용할 수 있는 색은 4가지에 대해 중복순열 생성
        for (int i = 1; i <= 4; i++) {
            sel[k] = i;
            rc(k + 1);
        }
    }

    private static boolean check() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
//                System.out.println(sel[i] + " " + sel[j]);
                if (arr[i][j] == 1 && sel[i] == sel[j]) {       // 인접하고 선택색이 같으면 놉! -> 인접 국가가 동일 색
                    return false;
                }
            }
        }
        return true;
    }
}