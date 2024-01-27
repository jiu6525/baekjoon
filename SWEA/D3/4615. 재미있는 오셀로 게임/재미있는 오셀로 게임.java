import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

//1
//4 12
//1 2 1
//1 1 2
//4 3 1
//4 4 2
//2 1 1
//4 2 2
//3 4 1
//1 3 2
//2 4 1
//1 4 2
//4 1 2
//3 1 2

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int start = 1; start<=t; start++) {
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
                for (int j = 0; j < q.length; j++) {
                    Stack<Integer> r = new Stack<>();
                    for (int mul = 1; mul < N; mul++) {
                        int ni = si + q[j][0] * mul;
                        int nj = sj + q[j][1] * mul;
                        if (1 <= ni && ni <= N && 1 <= nj && nj <= N) {
                            if (arr[ni][nj] == 0) {
                                break;
                            } else if (arr[ni][nj] == d) {
                                while (r.size() > 0) {
                                    int tj = r.pop();
                                    int ti = r.pop();
                                    arr[ti][tj] = d;
                                }
                                break;
                            } else {
                                r.push(ni);
                                r.push(nj);
                            }
                        } else {
                            break;
                        }
                    }
                }
            }

            int bcnt = 0, wcnt = 0;
            for (int[] lst : arr) {
                for (int value : lst) {
                    if (value == 1) {
                        bcnt++;
                    } else if (value == 2) {
                        wcnt++;
                    }
                }
            }
            System.out.printf("#%d %d %d\n",start,bcnt,wcnt);
        }
    }
}




//게임을 시작하며 N+1 짜리 이차원 배열을 선언
//        배열의 (m,m), (m+1,m+1) 위치에는 2(백돌)을
//        배열의 (m+1,m), (m,m+1) 위치에는 1(흑돌)로 초기화
//        start 메서드
//        M개의 입력을 받으며 해당 위치에 돌 놓기
//        주어진 범위를 탐색하며 돌을 저장할 스택 r 선언
//        팔방탐색을 통해 mul(1,N) 까지의 범위만큼 값 확인
//        만약 ni,nj가 0일경우 break
//        ni,nj가 d의 값과 일치한다면 스택이 빌때까지 스택에서 값을 pop한 뒤
//        전부 d로 변경해줌
//        0도 아니고 d 도 아니라면 값을 스택의 누적