import java.util.*;
class Solution {
    static int answer = 0;
    static Set<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        char[] arr = numbers.toCharArray();
        int size = arr.length;
        for(int i = 1; i<= numbers.length(); i++){
            char[] sel = new char[i];
            boolean[] v = new boolean[size];
            rc(0,arr,sel,v);
        }
        
        System.out.println(set);
        for(Integer n : set){
            if(isPrime(n)){
                answer++;
            }
        }
        return answer;
    }
    
    public static void rc(int k, char[] arr, char[] sel, boolean[] v){
        if(k == sel.length){
            String num = String.valueOf(sel);
            if(check(num)){
                int n = Integer.parseInt(num);
                if(n > 1){
                    set.add(n);    
                }
            }
            
            return;
        }
        
        for(int i = 0; i<arr.length; i++){
            if(!v[i]){
                v[i] = true;
                sel[k] = arr[i];
                rc(k+1, arr, sel,v);    
                v[i] = false;
            }
            
        }
    }
    
    public static boolean isPrime(int n){
        for(int i = 2; i<= (int)Math.sqrt(n); i++){
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }
    
    public static boolean check(String num){
        for(int i = 0; i<num.length(); i++){
            if(num.charAt(i) != '0'){
                return true;
            }
        }
        return false;
    }
}