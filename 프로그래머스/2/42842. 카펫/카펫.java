import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int res = brown + yellow;
        List<Integer> arr = new ArrayList<>();
        for(int i = 1; i <= res; i++){
            if(res%i == 0){
                arr.add(i);
            }
        }
        int size = arr.size();
        if(size % 2 != 0 ){
            answer[0] = arr.get(size/2);
            answer[1] = arr.get(size/2);
        }else{
            int start = 0;
            int end = size-1;
            while(start < end){
                int x = arr.get(start);
                int y = arr.get(end);
                if((x-2)*(y-2) == yellow && x * y == res){
                    break;
                }
                start++;
                end--;
            }
            answer[1] = arr.get(start);
            answer[0] = arr.get(end);
        }
        System.out.println(arr);
        return answer;
    }
}