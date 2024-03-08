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
        arr = new ArrayList<>();
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
			arr.add(Integer.parseInt(st.nextToken()));
		}
        min = Collections.min(arr);
        max = Collections.max(arr);
//        print();
        System.out.println(min+" "+max);
    }

}