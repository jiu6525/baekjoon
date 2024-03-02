import java.io.*;
import java.util.*;

public class Main {
    static class Robot{
        int x,y;
        int dir;

        public Robot(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }

        @Override
        public String toString() {
            return "Robot{" +
                    "x=" + x +
                    ", y=" + y +
                    ", dir=" + dir +
                    '}';
        }
    }
    static BufferedReader br;
    static StringTokenizer st;
    static int a,b,n, m;
    static int[][] arr;
                            // 0 1 2 3      동 남 서 북
    static int[][] direction = {{0, 1},{-1,0},{0,-1},{1,0}};
    static Robot[] robots;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        b = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        arr = new int[a][b];

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        robots = new Robot[n+1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            String s = st.nextToken();
            int dir = s.equals("E") ? 0 : s.equals("S")  ? 1 : s.equals("W") ? 2 : 3;
            robots[i] = new Robot(y-1,x-1,dir);
            arr[robots[i].x][robots[i].y] = i;
        }
//        for (Robot robot : robots) {
//            System.out.println(robot);
//        }
//        for (int[] lst : arr) {
//            System.out.println(Arrays.toString(lst));
//        }

        L:for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            String s = st.nextToken();
            int dir = s.equals("L") ? -1 : s.equals("R")  ? 1 : 0;
            int rotate = Integer.parseInt(st.nextToken());

            Robot robot = robots[type];

            for (int j = 0; j < rotate; j++) {
                int d = robot.dir + dir;
                robot.dir = d < 0 ? 3 : d > 3 ? 0 : d;
                if(dir == 0){
                    int nx = robot.x + direction[robot.dir][0];
                    int ny = robot.y + direction[robot.dir][1];
//                    System.out.println(nx + " " + ny);

                    if(nx<0 || nx>=a || ny<0 || ny>=b){
                        System.out.printf("Robot %d crashes into the wall",type);
                        flag = true;
                        break L;
                    }

                    if(arr[nx][ny] != 0){
                        System.out.printf("Robot %d crashes into robot %d",type,arr[nx][ny]);
                        flag = true;
                        break L;
                    }

//                print();
                    arr[robot.x][robot.y] = 0;
                    robot.x = nx;
                    robot.y = ny;
                    arr[robot.x][robot.y] = type;
//                    System.out.println();
//                    print();
                }
            }
        }

        if(!flag){
            System.out.println("OK");
        }
    }

    private static void print() {
        for (int[] lst : arr) {
            System.out.println(Arrays.toString(lst));
        }
    }
}
