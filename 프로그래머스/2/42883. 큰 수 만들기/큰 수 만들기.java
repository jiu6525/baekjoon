import java.util.*;
class Solution {
    public String solution(String number, int k) {
        int K = k;
        String answer = "";
        Stack<Character> s = new Stack<>();
        for(int i = 0; i< number.length(); i++){
            char num = number.charAt(i);
            while (true) {
                if (s.empty() || s.peek() >= num || k == 0) {
                    break;
                }
                s.pop();
                k--;
            }
            s.add(num);
        }
        int len = 0;
        for(Character c : s){
            if (len == number.length() - K) break;
            len += 1;
            answer += c;
        }
        
        //System.out.println(s);
        return answer;
    }
    
}