import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

    public class Main {
        static BufferedReader br;
        static StringTokenizer st;
        static int n;
        static Stack<Integer> stack = new Stack<>();
        public static void main(String[] args) throws IOException {
            //System.setIn(new FileInputStream("src/input.txt"));
            StringBuilder sb = new StringBuilder();
            br = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine());
            int s,e = 0;
            for (int i = 0; i < n; i++) {
                s = Integer.parseInt(br.readLine());
//                System.out.println(i + " " + s + " " + e);
                if(s >= e){
                    for (int j = e + 1; j <= s; j++) {
                        stack.add(j);
                        sb.append("+\n");
//                        System.out.println(j);
                    }
                    stack.pop();
                    sb.append("-\n");
                    e = s;
                }else{
                    Integer pop = stack.pop();
                    if(pop != s){
                        sb = new StringBuilder();
                        sb.append("NO");
                        break;
                    }else{
                        sb.append("-\n");
                    }
                }

            }
            System.out.println(sb);
        }
    }