import java.util.*;
class Solution {
    static int ans = Integer.MIN_VALUE;
    public static int solution(int k, int[][] dungeons) {
        int answer = -1;
        int size = dungeons.length;
        int[][] sel = new int[size][2];
        boolean[] v= new boolean[size];

        rc(0,dungeons, sel, v, k);

        return ans;
    }

    public static void rc(int idx, int[][] arr, int[][] sel, boolean[] v, int k){
        if(idx == sel.length){
            solve(sel,k);
            return;
        }

        for(int i = 0; i<arr.length; i++){
            if(!v[i]){
                v[i] = true;
                sel[idx][0] = arr[i][0];
                sel[idx][1] = arr[i][1];
                rc(idx+1,arr,sel,v,k);
                v[i] = false;
            }
        }
    }
    
    public static void solve(int[][] sel,int k){
        int cnt = 0;
        for(int i = 0; i<sel.length; i++){
            if(sel[i][0] <= k){
                k -= sel[i][1];
                cnt++;
            }
        }
        ans = Math.max(ans,cnt);
    }
}