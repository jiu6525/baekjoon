import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static int n,min,max;
    static List<Integer> arr;
    static int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};
    public static void main(String[] args) throws IOException {
    	//System.setIn(new FileInputStream("src/jiu/Main.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        for (int i = 1; i <= 9; i++) {
			System.out.printf("%d * %d = %d\n",n,i,n*i);
		}
    }

}