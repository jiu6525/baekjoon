import java.util.*;
class Solution {
    static int size;
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int ans = 0;
        size = friends.length;
        int[][] score = new int[size+1][size+1];
        int[] giftScore = new int[size+1];

        
        Map<String,Integer> map = new HashMap<>();
        for(int i = 0; i<size; i++){
            map.put(friends[i],i+1);
        }
        
        for(String gift:gifts){
            String[] tmp = gift.split(" ");
            score[map.get(tmp[0])][map.get(tmp[1])]++;
        }
        
        for(int[] s:score){
            System.out.println(Arrays.toString(s));
        }
        
        
        for(int i = 1; i<size+1; i++){
            for(int j = 1; j<size+1; j++){
                giftScore[i] -= score[j][i];
                giftScore[i] += score[i][j];
            }
        }
        
        System.out.println(Arrays.toString(giftScore));
        int[] name = new int[size+1];
        for (int i = 1; i < size+1; i++) {
            for (int j = i+1; j < size+1; j++) {
                if (i == j) {
                    continue;
                }
                if(score[i][j] > score[j][i]){
                    name[i]++;
                }else if(score[i][j] < score[j][i]){
                    name[j]++;
                }else{
                    if(giftScore[i] > giftScore[j]){
                        name[i]++;
                    }else if(giftScore[i] < giftScore[j]){
                        name[j]++;
                    }
                }
                
            }

        }
        
        for(int i = 1; i<size+1; i++){
            ans = Math.max(ans,name[i]);
        }
        System.out.println(ans);

        return ans;
    }
}