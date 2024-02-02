import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        
    	st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        while (ans <= 2000) {
            Queue<int[]> q = new LinkedList<>();
            int[][] v = new int[n][n];
            int flag = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (v[i][j] == 0) {
                        q.add(new int[]{i, j});
                        v[i][j] = 1;
                        LinkedList<int[]> alst = new LinkedList<>();
                        alst.add(new int[]{i, j});
                        int sm = arr[i][j];

                        while (!q.isEmpty()) {
                            int[] current = q.poll();
                            int ci = current[0];
                            int cj = current[1];

                            int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
                            for (int[] dir : directions) {
                                int ni = ci + dir[0];
                                int nj = cj + dir[1];
                                if (0 <= ni && ni < n && 0 <= nj && nj < n && v[ni][nj] == 0
                                        && l <= Math.abs(arr[ci][cj] - arr[ni][nj]) && Math.abs(arr[ci][cj] - arr[ni][nj]) <= r) {
                                    q.add(new int[]{ni, nj});
                                    v[ni][nj] = 1;
                                    alst.add(new int[]{ni, nj});
                                    sm += arr[ni][nj];
                                }
                            }
                        }

                        if (alst.size() > 1) {
                            for (int[] pos : alst) {
                                arr[pos[0]][pos[1]] = sm / alst.size();
                            }
                            flag = 1;
                        }
                    }
                }
            }

            if (flag == 0) {
                break;
            }
            ans++;
        }

        System.out.println(ans);
    }
}
