import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static int n,ans;
	static StringTokenizer st;
	static int[][] board = new int[100][100];
	public static void main(String[] args) throws NumberFormatException, IOException {
		//System.setIn(new FileInputStream("src/jiu/Main.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			rc(x,y,0);
		}
		
		System.out.println(ans);
		
		
	}
	private static void rc(int i, int j, int k) {
	    // 기저 조건
	    if (i >= 100 || j >= 100 || k > 9) {
	        return;
	    }

	    // 배열의 값이 0일 때만 채우고, 값이 1로 채워지면 ans 증가
	    if (board[i][j] == 0) {
	        board[i][j] = 1;
	        ans++;
	    }

	    // 재귀 호출
	    rc(i, j + 1, k + 1);
	    dc(i,j,0);
	}
	private static void dc(int i, int j, int k) {
	    if (i >= 100 || j >= 100 || k > 9) {
	        return;
	    }

	    // 배열의 값이 0일 때만 채우고, 값이 1로 채워지면 ans 증가
	    if (board[i][j] == 0) {
	        board[i][j] = 1;
	        ans++;
	    }
		
	    dc(i+1,j,k+1);
	}

}




//3
//3 7
//15 7
//5 2