import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.LinkedList;
        import java.util.Queue;
        import java.util.StringTokenizer;

// 인구차 계산 union 구성 -> 연합의 인구이동(평균)
// 첫날에 연합에 대한 중복 제거를 위한 배열 필요
// 이동시 ans 에 누적
// n*n 2500칸 2000번 재귀보다는 bfs(루프내부에 구현하는게 더 빠름)
//
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n,l,r;
    static int[][] v,arr;
    static Queue<int[]> q;
    static LinkedList<int[]> lst;
    static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        while (true) {      // 전체를 순회하면서, 미방문 연합 처리
            q = new LinkedList<>();
            v = new int[n][n];  // 방문처리를 위한 [n][n]크기의 v 배열 생성
            // 연합의 수를 확인하기위한 변수 생성

            boolean flag = bfs(arr, false);

            if (!flag) {    // 연합이 없음
                break;
            }
            ans++;
        }

        System.out.println(ans);
    }

    private static boolean bfs(int[][] arr, boolean flag) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (v[i][j] == 0) {     // 만약 중복이 아니라면 -> 한번도 안들린 곳이라면
                    q.add(new int[]{i, j});     // q에 i,j 값 추가
                    v[i][j] = 1;        // 방문처리
                    lst = new LinkedList<>(); // 연합의 추가
                    lst.add(new int[]{i, j});
                    int sm = arr[i][j];

                    while (!q.isEmpty()) {
                        int[] current = q.poll();
                        int ci = current[0];
                        int cj = current[1];


                        for (int[] dir : directions) {
                            int ni = ci + dir[0];
                            int nj = cj + dir[1];
                            if (0 <= ni && ni < n && 0 <= nj && nj < n && v[ni][nj] == 0        // 범위 내부 중복이 아닐때
                                    && l <= Math.abs(arr[ci][cj] - arr[ni][nj]) && Math.abs(arr[ci][cj] - arr[ni][nj]) <= r) {      // L <= 인구차 <= R 사이일 경우(현재위치와 이동할 위치의 인구차) q에 데이터 삽입, v에 방문처리
                                q.add(new int[]{ni, nj});
                                v[ni][nj] = 1;
                                lst.add(new int[]{ni, nj});
                                sm += arr[ni][nj];
                            }
                        }
                    }

                    if (lst.size() > 1) {       // 연합일때 처리(좌표마다 평균값 저장)
                        for (int[] pos : lst) {
                            arr[pos[0]][pos[1]] = sm / lst.size();
                        }
                        flag = true;   // 연합수가 하나 이상 -> 반복
                    }
                }
            }
        }
        return flag;
    }
}

//2 20 50
//50 30
//20 40