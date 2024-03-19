import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Map<String, Integer> m = new HashMap<>();
        for(int i = 0 ; i< phone_book.length; i++){
            m.put(phone_book[i], i);
        }
        
        for(int i = 0; i< phone_book.length; i++){
            for(int j = 0; j< phone_book[i].length(); j++){
                if(m.containsKey(phone_book[i].substring(0,j))){
                    answer = false;
                    break;
                }
            }
        }

        return answer;
    }
}