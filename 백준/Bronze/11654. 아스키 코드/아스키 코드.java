import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static int n,min,max;
    static List<Integer> arr;
    static char a;
    static int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};
    public static void main(String[] args) throws IOException {
    	//System.setIn(new FileInputStream("src/jiu/Main.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        a = br.readLine().charAt(0);
        
        System.out.println((int)a);
    }

}