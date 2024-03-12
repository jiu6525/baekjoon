import java.io.*;
import java.util.*;

//먼저 뱀은 몸길이를 늘려 머리를 다음칸에 위치시킨다.
//만약 벽이나 자기자신의 몸과 부딪히면 게임이 끝난다.
//만약 이동한 칸에 사과가 있다면, 그 칸에 있던 사과가 없어지고 꼬리는 움직이지 않는다.
//만약 이동한 칸에 사과가 없다면, 몸길이를 줄여서 꼬리가 위치한 칸을 비워준다. 즉, 몸길이는 변하지 않는다.
//X초가 끝난 뒤에 왼쪽(C가 'L') 또는 오른쪽(C가 'D')로 90도
public class Main {
    static class direction{
        int turn;
        int d;

        public direction(int turn, int d) {
            this.turn = turn;
            this.d = d;
        }
    }
    static BufferedReader br;
    static StringTokenizer st;
    static int n,k,l,ans = 0;
    static Queue<direction> snake_dir;
    static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    static LinkedList<int[]> snake,apple;
    static int c = 0;
    public static void main(String args[]) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        snake = new LinkedList<>();
        apple = new LinkedList<>();
        snake_dir = new LinkedList<>();
        snake.add(new int[]{0,0});

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            apple.add(new int[]{x,y});
        }

        l = Integer.parseInt(br.readLine());
        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine());
            int turn = Integer.parseInt(st.nextToken());
            char num = st.nextToken().charAt(0);
            int d = num == 'L' ? -1 : 1;
            snake_dir.add(new direction(turn,d));
        }

//          자기 몸에 닿는지 확인
//          전진
//          방향 전환 확인    turn 이 끝난뒤에 진행
//          사과 먹으면 연결리스트 추가
//          몸길이 즈악
//          정답 누적
        int dx = 0;
        int dy = 0;
        while(true){
            ans++;

//          이동
            int nx = dx + dir[c][0];
            int ny = dy + dir[c][1];

//          범위 벗어나고 자기 몸이랑 부딪히면
            if(!crush(nx, ny)){
                break;
            }

//           전진 사과 확인 -> 몸길이 증가
            snake.addFirst(new int[] { nx, ny });
            if(!eatCheck(nx, ny, apple)){
                snake.removeLast();
            }

//          방향 전환
            changeDir();
            dx = nx;
            dy = ny;
        }
        System.out.println(ans);
    }

    private static void changeDir() {
        int size = snake_dir.size();
        for (int i = 0; i < size; i++) {
            direction dir_check = snake_dir.poll();
            if(dir_check.turn == ans){
                c += dir_check.d;
                c = c < 0 ? dir.length-1 : (c == dir.length? 0 : c);
                break;
            }else{
                snake_dir.add(dir_check);
            }
        }
    }

    private static boolean eatCheck(int nx, int ny, LinkedList<int[]> arr) {
        int size = arr.size();
        for (int i = 0; i < size; i++) {
            int[] p = arr.poll();
            if (Arrays.equals(p, new int[]{nx, ny})) {
                return true;
            }else{
                arr.offer(p);
            }
        }
        return false;
    }

//    private static boolean duplicate(int nx, int ny) {
//        int size = snake.size();
//        for (int i = 0; i < size; i++) {
//            int[] p = snake.poll();
//            if (Arrays.equals(p, new int[]{nx, ny})) {
//                return true;
//            }else{
//                snake.offer(p);
//            }
//        }
//        return false;
//    }

    private static boolean crush(int nx, int ny) {
        if(nx < 0 || nx >= n || ny < 0 || ny>=n){
            return false;
        }
        for (int[] body : snake) {
            if (Arrays.equals(body, new int[]{nx, ny})) {
                return false;
            }
        }
        return true;
    }
}