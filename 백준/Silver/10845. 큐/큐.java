import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//push X: 정수 X를 큐에 넣는 연산이다.
//pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//size: 큐에 들어있는 정수의 개수를 출력한다.
//empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
//front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
public class Main {

    public static BufferedReader br;
    public static int n;
    public static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/input.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            String command = s[0];
            if(s.length > 1){
                int num = Integer.parseInt(s[1]);
                q.add(num);
            }else {
                if(command.equals("size")){
                    System.out.println(q.size());
                }else if(q.isEmpty()){
                    if(command.equals("front") || command.equals("back") || command.equals("pop")){
                        System.out.println("-1");
                    }else if(command.equals("empty")){
                        System.out.println("1");
                    }
                }else{
                    if(command.equals("front")){
                        System.out.println(q.peek());
                    }else if(command.equals("back")){
                        System.out.println(((LinkedList<Integer>) q).peekLast());
                    }else if(command.equals("pop")){
                        Integer poll = q.poll();
                        System.out.println(poll);
                    }else if(command.equals("empty")){
                        System.out.println("0");
                    }
                }

            }
        }
    }
}