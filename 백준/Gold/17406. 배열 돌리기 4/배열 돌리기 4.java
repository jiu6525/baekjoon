
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N,M,K, Ans = Integer.MAX_VALUE;
	static int[][] map, command;
	public static void main(String[] args) throws FileNotFoundException {
		//System.setIn(new FileInputStream("src/jiu/Main.txt"));
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		map = new int[N][M];
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				map[r][c] = sc.nextInt();
			}
		}
		
//		print(map);
		
		command = new int[K][3];
		for (int k = 0; k < K; k++) {
			command[k] = new int[] {sc.nextInt()-1, sc.nextInt()-1, sc.nextInt()};
		}
		
//		print(command);
//		순열
		permutation(0,new int[K], new boolean[K]);
		
		System.out.println(Ans);
	}
	private static void permutation(int idx, int[] sel, boolean[] v) {
//		basis part
		if(idx == sel.length) {
// 			명령어 순열이 sel[] 에 저장되어서 온다.
//			sel[] 로 배열을 돌려라
//			System.out.println(Arrays.toString(sel);
			int value = solve(sel);
			Ans = Math.min(Ans, value);
			return ;
		}
		
//		inductive part
		for (int i = 0; i < K; i++) {
			if(!v[i]) {
				v[i] = true;
				sel[idx] = i;
				permutation(idx+1, sel, v);
				v[i] = false;
			}
		}
		
	}
	private static int solve(int[] sel) {
//		배열 복사
		int[][] tmap = new int[map.length][map[0].length];
		for (int i = 0; i < tmap.length; i++) {
			tmap[i] = Arrays.copyOf(map[i], map[i].length);
		}
//		print(tmap);
//		sel[] 수만클 돌려라
		for (int i = 0; i < sel.length; i++) {
//			System.out.println(Arrays.toString(command[sel[i]]));
//			시작점, 종료점
//			r + s, c + s -> r - s, c - s
			int osr = command[sel[i]][0] - command[sel[i]][2];
			int osc = command[sel[i]][1] - command[sel[i]][2];
			int oer = command[sel[i]][0] + command[sel[i]][2];
			int oec = command[sel[i]][1] + command[sel[i]][2];

//			몇단계 돌려야 하나
			int step = Math.min(oer-osr, oec-osc)/2;
			
			for (int d = 0; d < step; d++) {
				int sr = osr + d;
				int sc = osc + d;
				int er = oer - d;
				int ec = oec - d;
				
				int dir = 0;
//				초기값 복사
				int tmp = tmap[osr+d][osc+d];
				while(dir < 4) {
					int nr = sr + dr[dir];
					int nc = sc + dc[dir];
					// 경계선 체크
					if(nr>=osr+d && nr<=oer-d && nc>=osc+d && nc<=oec-d) {
						tmap[sr][sc] = tmap[nr][nc];
						sr = nr;
						sc = nc;
					}else {
						dir++;
					}
				}
//				저장해 놨던 초기값을 마지막 칸에 복사한다.
				tmap[osr+d][osc+d+1] = tmp;
			}
		}
//		for (int[] is : tmap) {
//			System.out.println(Arrays.toString(is));
//		}
//		System.out.println();
//		최소값 구하기
		int min = Integer.MAX_VALUE;
		for (int r = 0; r < tmap.length; r++) {
			int tmp = 0;
			for (int c = 0; c < tmap[r].length; c++) {
				tmp = tmp + tmap[r][c];
			}
			min = Math.min(min, tmp);
		}
		return min;
	}
	static int dr[] = {1,0,-1,0};
	static int dc[] = {0,1,0,-1};
	private static void print(int[][] arr) {
		for (int[] lst : arr) {
			System.out.println(Arrays.toString(lst));
		}
		System.out.println();
	}
}