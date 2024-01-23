import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Stack<String> stack;
		int n;
		String lst;
		
		for(int start = 1; start<=10; start++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			lst = st.nextToken();
			
			stack = new Stack<>();
			
			for(int i=0; i<n; i++) {
				if(stack.size() == 0) {
					stack.push(String.valueOf(lst.charAt(i)-'0'));
				}else {
				String pop = stack.pop();
				String idx = String.valueOf(lst.charAt(i)-'0');
	
				if (!idx.equals(pop)) {
					stack.push(pop);
					stack.push(idx);
				}
				}
			}
			String ans = String.join("", stack);
			System.out.printf("#%d %s\n",start,ans);
		}
	}
}