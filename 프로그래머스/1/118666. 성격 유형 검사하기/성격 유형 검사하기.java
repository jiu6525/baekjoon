import java.util.*;

class Solution {
    static Map<String, Integer> map = new HashMap<>(){{
        put("R",0);
        put("T",0);

        put("C",0);
        put("F",0);

        put("J",0);
        put("M",0);

        put("A",0);
        put("N",0);
    }};
    public String solution(String[] survey, int[] choices) {
        for (int i = 0; i < choices.length; i++) {
            int choice = choices[i];
            String word = "";
            if(choice < 4) {
                word = String.valueOf(survey[i].charAt(0));
                map.put(word, map.getOrDefault(word, 0) + 4 - choice);
            }
            else{
                word = String.valueOf(survey[i].charAt(1));
                map.put(word, map.getOrDefault(word, 0) + choice - 4);
            }

        }
//        System.out.println(map);
        StringBuilder answer = new StringBuilder();
        answer
                .append(map.get("R") >= map.get("T") ? "R" : "T")
                .append(map.get("C") >= map.get("F") ? "C" : "F")
                .append(map.get("J") >= map.get("M") ? "J" : "M")
                .append(map.get("A") >= map.get("N") ? "A" : "N");

        System.out.println(answer);
        return answer.toString();
    }
}