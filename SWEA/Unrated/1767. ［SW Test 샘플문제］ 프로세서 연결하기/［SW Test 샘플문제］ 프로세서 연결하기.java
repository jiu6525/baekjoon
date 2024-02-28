import java.io.*;
import java.util.*;

//	갈수 있을경우 체크
//	지도 표시   0은 빈 cell 1 core
//	지도 원복
//1. 7 ≤  N ≤ 12
//2. Core 의 개수는 최소 1개 이상 12개 이하이다.
//3. 최대한 많은 Core 에 전원을 연결해도, 전원이 연결되지 않는 Core 가 존재할 수 있다.

//최대한 많은 Core 에 전원을 연결
//코어일때 좌표를 따로 저장하자
//전선은 직선 설치만 가능
//bfs 탐색을 통해 연결할수 있는지 확인후 연결할수 있다면 연결 이후 원복
public class Solution {
    static BufferedReader br;
    static StringTokenizer st;
    static int t, n, max_core, min_len;      // 최대 코어의 수, 최소 길이 누적
    static int[][] arr;
    static List<int[]> core_lst;
    static int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws NumberFormatException, IOException {
        //System.setIn(new FileInputStream("src/jiu/Solution.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n][n];
            core_lst = new ArrayList<>();
            max_core = 0;
            min_len = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    if (arr[i][j] == 1) {
                        if (i != 0 && j != n - 1 && i != n - 1 && j != 0) {     //가장자리 제외
                            core_lst.add(new int[]{i, j});
                        }
                    }
                }
            }

            rc(0,0);        // depth cnt, 코어의 수 sum
            System.out.printf("#%d %d\n", tc,min_len);
        }
    }

    private static void rc(int cnt, int sum) {
        if(cnt == core_lst.size()){
            if(sum > max_core){     //최대한 많은 코어 갱신
                max_core = sum;
                min_len = getLen();
            }else if(sum==max_core){        // 코어의 수가 같다면 길이 비교
                min_len = Math.min(min_len, getLen());
            }
            return;
        }

        int[] core = core_lst.get(cnt);
        int dx = core[0];
        int dy = core[1];

        for (int[] d : dir) {   // 갈수있을때만 가고 -> 가는길 체크 -> 갈수 없을때는 cnt+1
            if(check(dx,dy,d)){     // 이 길은 갈수 있어
                go(dx,dy,d,2);    // 지난길 2로 표시
                rc(cnt+1,sum+1);
                go(dx,dy,d,0);    // 현재 좌표값과 지나온 길을 0으로 원복하기
            }else{
                rc(cnt+1,sum);  // 못가
            }
        }
    }

    private static void go(int dx, int dy, int[] d, int k) {
        while(true){
            int nx = dx + d[0];
            int ny = dy + d[1];

            if(!rangeCheck(nx,ny)){
                break;
            }

            arr[nx][ny] = k;            // 방문배열 없이 지도에 그냥 표시해준다 -> 2는 전선 0은 원복
            dx = nx;
            dy = ny;
        }
    }


    private static boolean check(int dx, int dy, int[] d) {     //갈수 있는지 끝까지 확인 -> 전선은 직선으로만 이동
        while(true){    
            int nx = dx+d[0];
            int ny = dy+d[1];

            if(!rangeCheck(nx,ny)){
                break;
            }

            if(arr[nx][ny] != 0){
                return false;
            }

            dx = nx;
            dy = ny;
        }
        return true;
    }

    private static boolean rangeCheck(int nx, int ny) {     //범위 체크용
        if(nx<0 || nx>=n || ny<0 || ny>=n){
            return false;
        }
        return true;
    }


    public static int getLen() {        //전선의 길이를 세주자
        int cnt = 0;
        for (int[] lst : arr) {
            for (int i : lst) {
                if(i == 2){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}