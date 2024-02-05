
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n,m;

    public static void main(String[] args) throws NumberFormatException, IOException {
    	Queue<Integer> lst = new LinkedList<>();
    	st = new StringTokenizer(br.readLine());
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	List<String> ans = new ArrayList<>();
//    	n = 7;
//    	m = 3;
    	for (int i = 1; i <= n; i++) {
			lst.add(i);
		}
    	
    	while(!lst.isEmpty()) {
    		for (int i = 0; i < m-1; i++) {
				lst.add(lst.poll());
			}
    		ans.add(String.valueOf(lst.poll()));
    	}

    	System.out.printf("<%s>",String.join(", ",ans));
    }
}

//7 3 