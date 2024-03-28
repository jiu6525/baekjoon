import java.util.*;
class Solution {
    public static int[] solution(int[] answers) {
        int[] answer = new int[3];
        int[] a = {1,2,3,4,5};
        int[] b = {2,1,2,3,2,4,2,5};
        int[] c = {3,3,1,1,2,2,4,4,5,5};
        int idx = 0;
        for(int i = 0; i<answers.length; i++){
            if(a[idx%a.length] == answers[i]){
                answer[0]++;
            }
            if(b[idx%b.length] == answers[i]){
                answer[1]++;
            }
            if(c[idx%c.length] == answers[i]){
                answer[2]++;
            }
            idx++;
        }
        

        List<Integer> tmp = new ArrayList<>();
        for (int num : answer) {
            tmp.add(num);
        }
        
        int max_val = Collections.max(tmp);
        
        List<Integer> ans = new ArrayList<>();
        for(int i =0; i<answer.length; i++){
            if(answer[i] == max_val){
                ans.add(i+1);
            }
        }
        int[] array = ans.stream().mapToInt(Integer::intValue).toArray();

        return array;
    }
}