import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : scoville){
            pq.offer(i);
        }
        
        // 루프문에서 heap.peek이 K 이상일 때, answer를 더하지 않고 즉시 0을 리턴하는가
        // heap의 size가 2보다 작아 루프에서 탈출했을 때, heap.peek이 K 이상인지 확인 후 answer를 return 하는가
        while(pq.peek() < K){
            if(pq.size() == 1){
                return -1;
            }
            answer++;
            int x = pq.poll();
            int y = pq.poll();    
            int food = x + (y*2);
            pq.offer(food);
        }
        
        return answer;
    }
}