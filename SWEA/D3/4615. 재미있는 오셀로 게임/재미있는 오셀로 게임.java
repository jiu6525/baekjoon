import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int start = 1; start <= t; start++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] arr = new int[N + 1][N + 1];
            int[][] q = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
            int m = N / 2;
            arr[m][m] = arr[m + 1][m + 1] = 2;
            arr[m + 1][m] = arr[m][m + 1] = 1;

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int si = Integer.parseInt(st.nextToken());
                int sj = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                arr[si][sj] = d;

                for (int[] direction : q) {
                    Stack<Integer> r = new Stack<>();
                    int ni = si + direction[0];
                    int nj = sj + direction[1];

                    while (1 <= ni && ni <= N && 1 <= nj && nj <= N) {
                        if (arr[ni][nj] == 0) {
                            break;
                        } else if (arr[ni][nj] == d) {
                            while (!r.isEmpty()) {
                                int tj = r.pop();
                                int ti = r.pop();
                                arr[ti][tj] = d;
                            }
                            break;
                        } else {
                            r.push(ni);
                            r.push(nj);
                            ni += direction[0];
                            nj += direction[1];
                        }
                    }
                }
            }

            int bcnt = 0, wcnt = 0;
            for (int[] row : arr) {
                for (int value : row) {
                    if (value == 1) {
                        bcnt++;
                    } else if (value == 2) {
                        wcnt++;
                    }
                }
            }

            System.out.printf("#%d %d %d%n", start, bcnt, wcnt);
        }
    }
}