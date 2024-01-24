import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	int n = Integer.parseInt(br.readLine());
    	
    	List<Integer> arr = new ArrayList<>();
    	st = new StringTokenizer(br.readLine());
    	for(int i = 0; i<n; i++) {
    		arr.add(Integer.parseInt(st.nextToken()));
    	}
    	
    	Collections.sort(arr);
    	
    	List<Integer> lst = IntStream.rangeClosed(0, n)
    			.boxed()
    			.collect(Collectors.toList());
    	
        for (int i = 0; i < n; i++) {
            lst.set(i + 1, arr.get(i) + lst.get(i));
        }
    	
        int sum = lst.stream().mapToInt(Integer::intValue).sum();
    	System.out.println(sum);
   	
    }
}