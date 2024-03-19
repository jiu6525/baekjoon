import java.util.*;
class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> lst = new ArrayList<>();
        for(int i = 0; i<progresses.length; i++){
            int p = 100-progresses[i];
            int num = p%speeds[i];
            num = num>0 ? p/speeds[i]+1 : p/speeds[i];
            lst.add(num);
        }
        List<Integer> ans = new ArrayList<>();
        int check = lst.get(0);
        
        int cnt = 1;
        for(int i = 1; i<lst.size();i++){
            if(check < lst.get(i)){
                ans.add(cnt);
                cnt = 1;
                check = lst.get(i);
            }else{
                cnt++;
            }
        }
        ans.add(cnt);
        return ans;
    }
}