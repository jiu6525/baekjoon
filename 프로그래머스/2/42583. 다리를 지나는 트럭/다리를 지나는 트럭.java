import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        Queue<Integer> bridge = new LinkedList<>();
        int size = 0;
        int idx = 0;

        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }
    
        while (idx < truck_weights.length) {
            time++;
            int truckOnBridge = bridge.poll();
            size -= truckOnBridge;

            if (size + truck_weights[idx] <= weight) {
                bridge.offer(truck_weights[idx]);
                size += truck_weights[idx];
                idx++;
            } else {
                bridge.offer(0);
            }
        }

        time += bridge_length;

        return time;
    }
}
