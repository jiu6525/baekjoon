import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        int answer = 1;

        for(int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1); 
        }

        for(String key : map.keySet()) {
            answer *= (map.get(key) + 1);   // 지금 옷의 경우의 수와 안입는 옷 * 누적
        }

        return answer -= 1; // 아무것도 입지 않는경우
    }
}