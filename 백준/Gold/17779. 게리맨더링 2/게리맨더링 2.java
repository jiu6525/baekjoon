import java.util.Scanner;

public class Main {
    static int N;
    static int[][] arr;
    static int tot;

    public static int cal(int si, int sj, int d1, int d2) {
        int[][] v = new int[N][N];
        int[] alst = new int[5];

        // 5번구역에 표시
        v[si][sj] = 1;
        int j1 = sj, j2 = sj;
        for (int di = 1; di <= d1 + d2; di++) {
            if (di <= d1) j1--;       // j1감소
            else j1++;                // j1증가

            if (di <= d2) j2++;       // j2감소
            else j2--;                // j2증가
            for (int j = j1; j <= j2; j++) {
                v[si + di][j] = 1;
            }
        }

        // 1~4구역의 인구수 누적
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (v[i][j] == 1) continue;    // skip
                if (i < si + d1 && j <= sj) alst[0] += arr[i][j];  // 1번구역
                if (i <= si + d2 && sj < j) alst[1] += arr[i][j];
                if (si + d1 <= i && j < sj - d1 + d2) alst[2] += arr[i][j];
                if (si + d2 < i && sj - d1 + d2 <= j) alst[3] += arr[i][j];
            }
        }

        alst[4] = tot - alst[0] - alst[1] - alst[2] - alst[3];  // 5구역 인구수
        int minPop = Integer.MAX_VALUE, maxPop = Integer.MIN_VALUE;
        for (int pop : alst) {
            minPop = Math.min(minPop, pop);
            maxPop = Math.max(maxPop, pop);
        }
        return maxPop - minPop;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        arr = new int[N][N];

        tot = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = scanner.nextInt();
                tot += arr[i][j];
            }
        }

        int ans = 100 * N * N;
        for (int si = 0; si < N - 2; si++) {
            for (int sj = 1; sj < N - 1; sj++) {
                for (int d1 = 1; d1 < N; d1++) {
                    if (0 <= si + d1 && si + d1 < N && 0 <= sj - d1 && sj - d1 < N) {
                        for (int d2 = 1; d2 < N; d2++) {
                            if (0 <= si + d1 + d2 && si + d1 + d2 < N && sj + d2 < N) {
                                ans = Math.min(ans, cal(si, sj, d1, d2));
                            }
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }
}