import java.util.*;
class Solution {
public int solution(int[][] jobs) {
        int answer = 0;
        int size = jobs.length;

        Arrays.sort(jobs, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);    
    
        int time = 0;
        int idx = 0;
    
        while(idx < size || !pq.isEmpty()){
//          ;;;;;;;
            while(idx < size && jobs[idx][0] <= time){
                pq.offer(jobs[idx]);
                idx++;
            }
            
            if(!pq.isEmpty()){
                int[] target = pq.poll();
                int request = target[0];
                int work = target[1];
                
                time += work;
                answer += time-request;
            }else{
                time = jobs[idx][0];
            }
            
        }
    
        return answer / size;
    }
}