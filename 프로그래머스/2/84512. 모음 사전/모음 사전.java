import java.util.*;
class Solution {
    static List<String> arr = new ArrayList<>();
    static char[] dic = {'A', 'E', 'I', 'O', 'U'};
    public int solution(String word) {
        int answer = 0;


        for(int i = 1; i<6; i++){
            char[] sel = new char[i];
            rc(0,sel);    
        }
        Collections.sort(arr);
        answer = Collections.binarySearch(arr,word)+1;
        
        return answer;
    }
    public static void rc(int k,char[] sel){
        if(k == sel.length){
            arr.add(String.valueOf(sel));
            return;
        }
        
        for(int i=0; i<dic.length;i++){
            sel[k] = dic[i];
            rc(k+1,sel);
        }
    }
}