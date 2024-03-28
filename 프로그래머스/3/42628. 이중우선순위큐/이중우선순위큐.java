import java.util.*;

class Solution {
    public int[] solution(String[] operation) {
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>((a, b) -> Integer.compare(b, a)); 
        for(String oper : operation){
            String[] o = oper.split(" ");
            String command = o[0];
            int num = Integer.parseInt(o[1]);
            if(command.equals("I")){
                minQueue.offer(num);
                maxQueue.offer(num);
            }else{
                if(num == 1){
                    if(!maxQueue.isEmpty())
                        minQueue.remove(maxQueue.poll());
                }else{
                    if(!minQueue.isEmpty())
                        maxQueue.remove(minQueue.poll());
                }
            }

        }
        
        System.out.println(minQueue);
        System.out.println(maxQueue);
        
        int[] answer = new int[2];

        
        if(!maxQueue.isEmpty()){
            answer[0] = maxQueue.poll();    
        }
        
        if(!minQueue.isEmpty()){
            answer[1] = minQueue.poll();    
        }
        
        return answer;
    }
}