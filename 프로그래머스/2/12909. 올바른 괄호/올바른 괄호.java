import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Integer> sa = new Stack<>();
        for(int i = 0; i<s.length(); i++){
            char num = s.charAt(i);
            if(num == '('){
                sa.add(1);
            }else{
                if(sa.isEmpty()){
                    answer = false;
                    break;
                }
                sa.pop();
            }
        }
        
        answer = !sa.isEmpty() ? false : answer;
        return answer;
    }
}