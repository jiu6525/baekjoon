import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int n,m,c_len;
	static int[][] arr;
	static List<int[]> house = new ArrayList<>();
	static List<int[]> chicken = new ArrayList<>();
	static Stack<int[]> sel = new Stack<>();
	static int ans = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		//System.setIn(new FileInputStream("src/jiu/Main.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		print();

//		집과 치킨의 좌표를 저장
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(arr[i][j] == 1) {
					house.add(new int[] {i,j});
				}else if(arr[i][j] == 2) {
					chicken.add(new int[] {i,j});
				}
			}
		}
		
			
		c_len = chicken.size();
//		for (int[] l : chicken) {
//			System.out.print(Arrays.toString(l));
//		}
//		System.out.println();
		
//		치킨집 수만큼 dfs 수행
		for (int i = 0; i < c_len; i++) {
			dfs(i);
		}
		
		System.out.println(ans);
	}
	
	
	
	private static void dfs(int num) {
		
		int res = 0;
//		sel의 개수가 m이 될때까지
		if (sel.size()==m) {
//			각 집마다의 치킨거리를 계산 해서 ans 값 최신화
			for (int i = 0; i < house.size(); i++) {
				int r = house.get(i)[0];
				int c = house.get(i)[1];
				int d = Integer.MAX_VALUE;
				for (int j = 0; j < sel.size(); j++) {
					int nr = sel.get(j)[0];
					int nc = sel.get(j)[1];
					int tmp = Math.abs(r-nr) + Math.abs(c-nc);
					if(tmp<d) {
						d = tmp;
					}
				}
				res += d;
			}
			
			if(res<ans) {
				ans= Math.min(res, ans);
				return;
			}
			
		}
		
//		for (int[] is : sel) {
//			System.out.print(Arrays.toString(is));
//		}
//		System.out.println();
		
//		sel stack으로 현재 치킨집 가져오고 dfs 수행 후 pop
		for (int i = num; i < c_len; i++) {
			sel.add(chicken.get(i));

			dfs(i+1);
			sel.pop();
		}
		

	}



	private static void print() {
		for (int[] lst : arr) {
			System.out.println(Arrays.toString(lst));
		}
	}
}




//3
//3 7
//15 7
//5 2