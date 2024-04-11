import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution {
	static class Bc implements Comparable<Bc> {
		int power, idx;

		public Bc(int power, int idx) {
			this.power = power;
			this.idx = idx;
		}

		@Override
		public String toString() {
			return "Bc [power=" + power + ", idx=" + idx + "]";
		}

		public Bc() {
		}
		
	    public int compareTo(Bc bc) {
	        return Integer.compare(this.power, bc.power);
	    }
		
	}
	static BufferedReader br;
	static StringTokenizer st;
	static int size = 11;
	static List<List<List<Bc>>> arr;
	static int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
	static int t,n,m,ans;
	static int[][] user;
	static int[][] userDir;
	public static void main(String[] args) throws Exception{
        //System.setIn(new FileInputStream("src/jiu/Solution.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			user = new int[2][n];
			userDir = new int[][]{{1,1},{10,10}};
			ans = 0;
			createArr();
			for (int i = 0; i < user.length; i++) {
				st = new StringTokenizer(br.readLine());
				
				for (int j = 0; j < n; j++) {
					user[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				
				bfs(y,x,r,p,i);
			}
			
//			print();

			for (int i = 0; i < 2; i++) {
				List<Bc> lst = arr.get(userDir[i][0]).get(userDir[i][1]);
				Collections.sort(lst, Collections.reverseOrder());
				if(!lst.isEmpty()) {
					ans += lst.get(0).power;
				}
			}
			
			for (int i = 0; i < user[0].length; i++) {
//				System.out.print(user[0][i] + " " + user[1][i]);
//				System.out.println();
				cal(i);
			}
			
			System.out.printf("#%d %d\n",tc,ans);
		}
		
		
		
	}
	private static void cal(int i) {
		int a = user[0][i];
		int[] user1 = userDir[0];
		int dx1 = user1[0];
		int dy1 = user1[1];
		
		if(a != 0) {
			dx1 += dir[a-1][0];
			dy1 += dir[a-1][1];
		}
		
		userDir[0] = new int[]{dx1,dy1};
		
		
		int b = user[1][i];
		int[] user2 = userDir[1];
		int dx2 = user2[0];
		int dy2 = user2[1];
		
		if(b != 0) {
			dx2 += dir[b-1][0];
			dy2 += dir[b-1][1];
		}
		
		userDir[1] = new int[]{dx2,dy2};
		
		List<Bc> bcLst1 = arr.get(dx1).get(dy1);
		List<Bc> bcLst2 = arr.get(dx2).get(dy2);
		
		Collections.sort(bcLst1, Collections.reverseOrder());
		Collections.sort(bcLst2, Collections.reverseOrder());

		if(bcLst1.size() >= 1 && bcLst2.size() >= 1) {
			Bc bc1 = bcLst1.get(0);
			Bc bc2 = bcLst2.get(0);
			if(bc1.power == bc2.power) {
				if(bc1.idx == bc2.idx) {
					if(bcLst1.size() >= 2 && bcLst2.size() >= 2) {
						bc1 = bcLst1.get(1);
						bc2 = bcLst2.get(1);
						ans += bcLst1.get(0).power + Math.max(bc1.power, bc2.power);
					}else if(bcLst1.size() >= 2) {
						bc1 = bcLst1.get(1);
						ans += bc2.power + bc1.power;
					}else if(bcLst2.size() >= 2) {
						bc2 = bcLst2.get(1);
						ans += bc1.power + bc2.power;
					}else {
						ans += bc1.power;
					}
				}else {
					ans += bc1.power * 2;
				}
			}else {
				ans += bc1.power + bc2.power;
			}
		}else if(bcLst1.size() >= 1 && bcLst2.isEmpty()) {
			ans += bcLst1.get(0).power;
		}else if(bcLst2.size() >= 1 && bcLst1.isEmpty()) {
			ans += bcLst2.get(0).power;
		}
		
//		System.out.println(bcLst1 + "\t\t\t\t" + bcLst2);

	}
	private static void bfs(int x, int y, int r, int p, int cntBc) {
		boolean[][] v = new boolean[size][size];
		int[][] map = new int[size][size];
		Queue<int[]> q = new LinkedList<>();
		map[x][y] = 1;
		arr.get(x).get(y).add(new Bc(p,cntBc));
		v[x][y] = true;
		q.offer(new int[] {x,y});
		
		while(!q.isEmpty()) {
			int[] po = q.poll();
			int dx = po[0];
			int dy = po[1];
			
			if(map[dx][dy] == r+1) {
				break;
			}
			
			for (int[] d : dir) {
				int nx = dx + d[0];
				int ny = dy + d[1];
				
				if(nx < 0 || nx>= size || ny < 0 || ny >= size) {
					continue;
				}
				
				if(map[nx][ny] != 0) {
					continue;
				}
				
				map[nx][ny] = map[dx][dy] + 1;
				arr.get(nx).get(ny).add(new Bc(p,cntBc));
				q.offer(new int[] {nx,ny});
			}
			
		}
	}

	private static void createArr() {
		arr = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			arr.add(i,new ArrayList<>());
			for (int j = 0; j < size; j++) {
				arr.get(i).add(j,new ArrayList<>());
			}
		}
		
		
	}
	private static void print() {
		for (int[] l : user) {
			System.out.println(Arrays.toString(l));
		}
		
		for (List<List<Bc>> lst: arr) {
			System.out.println(lst);
		}
	}
}