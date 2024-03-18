import java.util.*;
class Solution {
    public int solution(int[] nums) {
        Set<Integer> m = new HashSet<>();
        for(int i = 0; i<nums.length; i++){
            m.add(nums[i]);
        }
        int sel = nums.length/2;
    	int ans = m.size();
    	ans = sel<ans ? sel : ans;
        return ans;
    }
}