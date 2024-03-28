import java.util.*;
class Solution {
public int solution(int[][] jobs) {
        int answer = 0;
        int size = jobs.length;

        Arrays.sort(jobs, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt((int[] a) -> a[1]));

        int time = 0;
        int index = 0;
        while (index < size || !pq.isEmpty()) {
            while (index < size && jobs[index][0] <= time) {
                pq.offer(jobs[index]);
                index++;
            }
            if (!pq.isEmpty()) {
                int[] target = pq.poll();
                int request = target[0];
                int work = target[1];
                time += work;
                answer += time - request;
            } else {
                time = jobs[index][0];
            }
        }
        
        return answer / size;
    }
}