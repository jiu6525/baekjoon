import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int t,n;
    static Integer[] lst;
    public static void main(String[] args) throws NumberFormatException, IOException {
    	t = Integer.parseInt(br.readLine());
    	for(int start = 1; start<=t; start++) {
	    	n = Integer.parseInt(br.readLine());
	    	st = new StringTokenizer(br.readLine());
	    	lst = new Integer[n];
	    	for(int i = 0; i < n; i++) {
	    		lst[i] = Integer.parseInt(st.nextToken());
	    	}
	    	int sum = 0;
	    	List<Integer> arr = new ArrayList<>();
	    	Arrays.sort(lst,Collections.reverseOrder());
	    	
	    	for (int i = 0; i < n; i++) {
				arr.add(lst[i]);
				if(arr.size() == 3) {
					sum += arr.stream().mapToInt(Integer::intValue).sum();
					sum -= arr.get(arr.size()-1);
					arr = new ArrayList<>();
				}
			}
	    	
	    	if(!arr.isEmpty()) {
	    		for (Integer a : arr) {
					sum += a;
				}
	    	}
	    	
	    	System.out.printf("#%d %d\n",start,sum);
    	}
    }
}

//7 3 