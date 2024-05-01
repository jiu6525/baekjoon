class Solution {
    static int[] sale = {10,20,30,40};
    static int[] sel;
    static int cnt=0,money = 0;
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        sel = new int[emoticons.length];
        recursive(0,users, emoticons);
        answer[0] = cnt;
        answer[1] = money;
        return answer;
    }
    
     private static void recursive(int k,int[][] users, int[] emoticons) {
        if(k==sel.length) {
            cal(sel, users, emoticons);
            return;
        }

        for(int i=0;i<sale.length;i++){
            sel[k]=i;
            recursive(k+1,users, emoticons);
        }
    }

    public static void cal(int[] sel, int[][] users, int[] emoticons){
        int tmpCnt=0;
        int tmpMoney=0;

        for(int[] user:users){
            int discount= user[0];
            int price =user[1];
            int sum=0;

            for(int i=0;i<sel.length;i++){
                if(sale[sel[i]]>=discount){
                    sum+=(emoticons[i] - (emoticons[i]*0.01*sale[sel[i]]));
                }
            }

            if(sum>=price){
                tmpCnt++;
            } else{
                tmpMoney+=sum;
            }
        }

        if(tmpCnt>cnt){
            cnt=tmpCnt;
            money=tmpMoney;
        }
        else if(tmpCnt==cnt){
            money = Math.max(money,tmpMoney);
        }

    }
}