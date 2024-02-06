import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n,m,k;
    static String s;
    static int[][] arr;
    static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("src/homework/Main.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        arr = new int[n][m];
        for(int i = 0; i<n; i++) {
        	String line = br.readLine();
        	for(int j = 0; j<m; j++) {
        		arr[i][j] = line.charAt(j)-'0';
        	}

        }


        bfs(0,0);
        System.out.println(arr[n-1][m-1]);
    }
	private static void bfs(int i, int j) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[]{i,j});
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			int x = poll[0];
			int y = poll[1];
			
			for (int[] d : dir) {
				int dx = x + d[0];
				int dy = y + d[1];
				
				if(dx<0 || dx>=n || dy<0 || dy>=m) {
					continue;
				}
				
				if(arr[dx][dy] == 0 || arr[dx][dy] != 1) {
					continue;
				}else {
					arr[dx][dy] = arr[x][y] + 1;
					q.add(new int[] {dx,dy});
							
				}
				
			}
			
//			int dx = 
		}
	}
    
    
}