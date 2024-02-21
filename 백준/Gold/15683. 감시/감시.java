//package jiu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 5 개의 cctv
// 1 우
// 2 좌 우
// 3 상 우
// 4 좌 상 우
// 5 좌 상 우 하
// 0 빈칸 6 벽 나머지는 cctv
// 입력받을때 cctv 의 위치를 저장?

// cctv 의 길이 cnt 변수 선언
// n+2, m+2 만큼 크기를 늘려서 6으로 표시함 -> 탐색하기 편하게
// dfs 에서 0도 90도 180도 270 회전을 연산하여 정답 갱신 n값과 임시 배열 전달
// 0의 개수를 카운트 할 cal 메서드 구현 필요한거? -> 방문배열, cctv에 대한 처리(좌표, cctv 번호, 회전방향  0 ~ 3)
// cnt 반큼 반복하며 좌표값 초기화, 회전방향 구하기, cctv 식별 cctv[type]만큼 반복하며 v에 표시
// 0 상 1 우 2 하 3 좌
// cctv = [[], [1],[1,3],[0,1],[0,1,3],[0,1,2,3]]
//
public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int  n, m, cctv_len, ans = 0;
    static int[][] arr;
    static List<int[]> lst;
    //	cctv의 번호					1	  2		 3		4		 5
    static int[][] cctv = {{}, {1}, {1,3} ,{0,1},{0,1,3},{0,1,2,3}};
    public static void main(String[] args) throws NumberFormatException, IOException {
        //System.setIn(new FileInputStream("src/jiu/Main.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n+2][m+2];
        lst = new ArrayList<>();
        ans = Integer.MAX_VALUE;
//		[0, 0, 0, 0, 0, 0]
//		[0, 0, 0, 0, 0, 0]
//		[0, 0, 5, 0, 6, 0]
//		[0, 0, 0, 0, 0, 0]
        for (int i = 0; i < n+2; i++) {
            for (int j = 0; j < m+2; j++) {
                arr[i][j] = 6;
            }
        }

        for (int i = 1; i < n+1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < m+1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j]>0 && arr[i][j] <6) {
                    lst.add(new int[] {i,j});
                }
            }
        }

        cctv_len = lst.size();
//		깊이와 방향을 알려주는 배열
        dfs(0,new ArrayList<>());

        System.out.println(ans);
    }

// dfs 에서 0도 90도 180도 270 회전을 연산하여 정답 갱신 n값과 임시 배열 전달
// 0의 개수를 카운트 할 cal 메서드 구현 필요한거? -> 방문배열, cctv에 대한 처리(좌표, cctv 번호, 회전방향  0 ~ 3)
// cnt 반큼 반복하며 좌표값 초기화, 회전방향 구하기, cctv 식별 cctv[type]만큼 반복하며 v에 표시
// 0 상 1 우 2 하 3 좌
    static int[] di = {-1,0,1,0};
    static int[] dj = {0,1,0,-1};

//	static int[][] cctv = {{}, {1}, {1,3} ,{0,1},{0,1,3},{0,1,2,3}};
    private static int cal(List<Integer> tmp) {
        int[][] v = new int[n+2][];	//		1의 표시를 해줄 v 배열 생성
        for (int i = 0; i < arr.length; i++) {
            v[i] = arr[i].clone();
        }
        for (int i = 0; i < cctv_len; i++) {
            int[] p = lst.get(i);
            int dx = p[0];
            int dy = p[1];
            int direction = tmp.get(i);	// 현재 바라보는 방향
            int type = arr[dx][dy];				// cctv 의 번호

//			cctv의 타입만큼 반복 진행
            for (int j = 0; j < cctv[type].length; j++) {
                int rc = cctv[type][j];
                rc = (rc+direction)%4;
                int nx = dx;
                int ny = dy;
                v[nx][ny] = 1;
                while(true) {
                    nx = nx + di[rc];
                    ny = ny + dj[rc];
                    if(arr[nx][ny] == 6) {
                        v[nx][ny] = 6;
                        break;
                    }
                    v[nx][ny] = 1;
                }
            }
        }

        int cnt = 0;
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if(arr[i][j] == 0 && v[i][j] == 0) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    //								깊이			방향
    private static void dfs(int depth, List<Integer> tmp) {
        if(depth == cctv_len) {
//			System.out.println(tmp);
            ans = Math.min(ans, cal(tmp));
            return ;
        }

//      0,1,2,3 의 방향 만큼
        for (int direction = 0; direction < 4; direction++) {
            tmp.add(direction);
            dfs(depth + 1, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }

    private static void print(int[][] map) {
        for (int[] lst : map) {
            System.out.println(Arrays.toString(lst));
        }
    }
}