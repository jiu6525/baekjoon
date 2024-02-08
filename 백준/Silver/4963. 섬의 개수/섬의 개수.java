import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int w,h;
	static int[][] arr;
	static int ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream("src/jiu/Main.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));

		while(true) {
			ans = 0;
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if(w == 0 & h == 0) {
				break;
			}
			arr = new int[h][w];
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
//			print();
			
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if(arr[i][j] != 0) {
						if(dfs(i,j)) {
							ans++;
						}
					}
				}
			}
			
			System.out.println(ans);
			
		}

		
	}
	private static boolean dfs(int x, int y) {
		if(x<0 || y<0 || x>=h || y>=w) {
			return false;
		}
		
		if(arr[x][y] != 0) {
			arr[x][y] = 0;
			dfs(x-1,y);
			dfs(x+1,y);
			dfs(x,y-1);
			dfs(x,y+1);
			dfs(x-1,y-1);
			dfs(x-1,y+1);
			dfs(x+1,y-1);
			dfs(x+1,y+1);
			
			return true;
		}
		
		return false;
		
		
		
	}
	private static void print() {
		for (int[] test : arr) {
			System.out.println(Arrays.toString(test));
		}
	}
}




//3
//3 7
//15 7
//5 2