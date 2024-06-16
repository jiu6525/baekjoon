import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int n,m;
    static int[] arr;
    static int s, e, ans;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String comm = st.nextToken();
            if(comm.equals("push")){
                stack.push(Integer.parseInt(st.nextToken()));
            }else if(comm.equals("pop")){
                if(stack.isEmpty()){
                    sb.append(-1 + "\n");
                }else{
                    sb.append(stack.pop() + "\n");
                }
            }else if(comm.equals("size")){
                sb.append(stack.size() + "\n");
            }else if(comm.equals("empty")){
                if(stack.isEmpty()){
                    sb.append(1 + "\n");
                }else{
                    sb.append(0 + "\n");
                }
            }else if(comm.equals("top")){
                if(stack.isEmpty()){
                    sb.append(-1 + "\n");
                }else{
                    sb.append(stack.peek() + "\n");
                }
            }
        }
        System.out.println(sb);
    }
}