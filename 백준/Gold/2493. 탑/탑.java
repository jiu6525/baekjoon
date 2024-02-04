import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n;
    static Stack<int[]> s = new Stack<>();
    public static void main(String[] args) throws IOException {
//  스택에 값 추가하기(idx, 입력받은 값)
//  스택의 마지막 값 {idx,val} 의 [1] 번째 확인해서 현재값이 작다면 현재 idx sb에 추가
//  stack 에서 값 빼기 
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int idx = 0; idx< n; idx++){
            int val = Integer.parseInt(st.nextToken());
            while(!s.isEmpty()){
                if(val < s.peek()[1]){
                    sb.append(s.peek()[0] + 1 + " ");
                    break;
                }
                s.pop();
            }
            if(s.isEmpty()){
                sb.append("0 ");
            }
            s.push(new int[]{idx, val});
        }
        System.out.println(sb);
    }
}

