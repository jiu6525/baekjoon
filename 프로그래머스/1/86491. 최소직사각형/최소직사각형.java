import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int s = sizes.length;
        List<Integer> w = new ArrayList<>();
        List<Integer> h = new ArrayList<>();
        
        for(int i = 0; i < s; i++) {
            w.add(Math.max(sizes[i][0], sizes[i][1]));
            h.add(Math.min(sizes[i][0], sizes[i][1]));
        }
        
        Collections.sort(w, Collections.reverseOrder());
        Collections.sort(h, Collections.reverseOrder());
        
        int ww = w.get(0);
        int hh = h.get(0);
        
        return ww * hh;
    }
}
