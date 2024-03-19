import java.util.*;

class Solution {
    public static int solution(int[] priorities, int location) {
        Queue<int[]> queue = new LinkedList<>();
        int[] order = new int[priorities.length];
        for (int i = 0; i < priorities.length; i++) {
            queue.add(new int[]{i, priorities[i]});
        }

        int idx = 1;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            if (isFirst(poll[1], queue)) {
                order[poll[0]] = idx;
                idx++;
            } else {
                queue.add(poll);
            }
        }

        return order[location];
    }

    public static boolean isFirst(int order, Queue<int[]> list) {
        Queue<int[]> temp = new LinkedList<>(list);
        while (!temp.isEmpty()) {
            int[] poll = temp.poll();
            if (poll[1] > order) {
                return false;
            }
        }
        return true;
    }

}