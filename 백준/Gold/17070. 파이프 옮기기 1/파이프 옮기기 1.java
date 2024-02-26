import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n;
    static int[][] arr;
//  가로 세로 대각선만 이동하면 됨
//  파이프의 위치 - 가로 : w , 세로 : h, 대각 : d
    static char state = 'w';
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
//        print(arr);
        dfs(0,1,state); // 좌표, 방향
        System.out.println(ans);
    }

    private static void dfs(int nx, int ny, char state) {
//       0일때를 안봄 브레이크 고장남,,
        if(nx>=n|| ny>=n){
            return;
        }

        if(state == 'd'){
            if(arr[nx-1][ny] == 1 || arr[nx][ny-1] == 1){
                return;
            }
        }


        if(arr[nx][ny] == 1){
            return;
        }

        if(nx == n-1 && ny == n-1){
            ans++;
            return;
        }

        if(state == 'w'){
            dfs(nx,ny+1,state);
            dfs(nx+1,ny+1,'d');
        }else if(state == 'h'){
            dfs(nx+1,ny,state);
            dfs(nx+1,ny+1,'d');
        }else{
            dfs(nx+1,ny+1,state);
            dfs(nx+1,ny,'h');
            dfs(nx,ny+1,'w');
        }
    }

    private static void print(int[][] arr) {
        for (int[] lst : arr) {
            System.out.println(Arrays.toString(lst));
        }
    }

}