import java.util.Arrays;
import java.util.Stack;

class Solution {
    public static long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        Stack<Integer> deliver = new Stack<>();
        Stack<Integer> pickup = new Stack<>();
        System.out.println(cap);
        System.out.println(n);
        for (int i = 0; i < n; i++) {
            if(deliveries[i] != 0){
                deliver.add(i);
            }
            if(pickups[i] != 0){
                pickup.add(i);
            }
        }


        while(!deliver.isEmpty() || !pickup.isEmpty()){
            int num = 0;
            if(deliver.isEmpty() && !pickup.isEmpty()){
                num = cal(cap, pickups, pickup);
                answer += (num+1)*2;
            }else if(deliver.isEmpty() && !pickup.isEmpty()){
                num = cal(cap, deliveries, deliver);
                answer += (num+1)*2;
            }else{
                int pick = cal(cap, pickups, pickup);
                int deli = cal(cap, deliveries, deliver);
                answer += (Math.max(pick, deli)+1)*2;

            }
        }
        System.out.println(deliver);
        System.out.println(pickup);
        return answer;
    }

    private static int cal(int cap, int[] pickups, Stack<Integer> pickup) {
        int capCnt = 0;
        int res = 0;
        while(cap > capCnt){
            if(pickup.isEmpty()){
                break;
            }
            int idx = pickup.peek();
            res = Math.max(res, idx);

            if(pickups[idx] + capCnt > cap){
                int diff = cap - capCnt;
                pickups[idx] -= diff;
                capCnt = cap;
            }else{
                capCnt += pickups[idx];
                pickup.pop();
            }
        }

        return res;
    }
}