import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> answer = new Stack<>();

        for(int n : arr){
            if(answer.isEmpty()) {
                answer.add(n);
            }
            if(answer.peek() == n){
                continue;
            }else{
                answer.add(n);
            }
        }
        
        int[] ans = new int[answer.size()];
        for (int i = 0; i < ans.length; i++) {
			ans[i] = answer.get(i);
		}
        return ans;
    }
}