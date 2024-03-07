import java.io.*;
import java.util.*;

public class Main {
    static class Shark implements Comparable<Shark>{
        char n;
        int r,c,s,d,z;

        public Shark(char n,int r, int c, int s, int d, int z) {
            this.n = n;
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }

        @Override
        public String toString() {
            return "Shark [n=" + n + ", r=" + r + ", c=" + c + ", s=" + s + ", d=" + d + ", z=" + z + "]";
        }

        @Override
        public int compareTo(Shark o) {
            if(this.c == o.c) {
                if(this.r == o.r)
                    return -Integer.compare(this.z, o.z);            //같은 행과 열일때는 크기반환
                else
                    return Integer.compare(this.r, o.r);
            } else
                return Integer.compare(this.c, o.c);
        }
    }
    static BufferedReader br;
    static StringTokenizer st;
    static int R,C,M,ans;
    static int[][] arr;
    static PriorityQueue<Shark> pq;
    static Queue<Shark> q;
    //                            위       아래   오    왼
    static int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ans = 0;

        q = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken()) - 1;
            int z = Integer.parseInt(st.nextToken());
            q.offer(new Shark((char)(i+65),r,c,s,d,z));
        }
//        print();

        for (int i = 0; i < C; i++) {
//            System.out.println(i);
            pq = new PriorityQueue<>(q);
            int dr = -1;
            int dc = -1;
            int dz = -1;
            while(!pq.isEmpty()) {
                Shark p = pq.poll();
                if(p.c == i) {
                    dr = p.r;
                    dc = p.c;
                    dz = p.z;
                    ans += p.z;
                    break;
                }
            }

            if(dr != -1 && dc != -1){
                int size = q.size();
                for (int j = 0; j < size; j++) {
                    Shark p = q.poll();
                    if(p.r == dr && p.c == dc){
                        break;
                    }else{
                        q.add(p);
                    }
                }
            }
            move();
            // r과 c가 같은 Shark 중에서 z가 큰 것을 남기고 작은 것을 제거
            duplicateRC();
//            print();
        }
//        print();
        System.out.println(ans);
    }

    private static void duplicateRC() {
        Map<String, Shark> duplicate = new HashMap<>();

        // 큐를 순회하면서 중복제거
        while (!q.isEmpty()) {
            Shark p = q.poll();
            String key = p.r + "_" + p.c;

            // 맵에 저장된 Shark 와 비교하여 큰 z 값을 가진 Shark 저장
            if (duplicate.containsKey(key)) {
                Shark shark = duplicate.get(key);
                if (p.z > shark.z) {
                    duplicate.put(key, p);
                }
            } else {
                duplicate.put(key, p);
            }
        }

        // 맵에 저장된 Shark 를 다시 큐에 추가
        q.addAll(duplicate.values());
    }

    private static void move() {
        for (int i = 0; i < q.size(); i++) {
            Shark p = q.poll();
            int moving = 0;
            if(p.d <= 1) {
                moving = (p.s) % (R+R-2);
            } else {
                moving = (p.s) % (C+C-2);
            }

            int nx = p.r;
            int ny = p.c;
            int d = p.d;
            while(moving-- > 0) {
                nx += dir[d][0];
                ny += dir[d][1];
                if(nx < 0 || nx >= R || ny < 0 || ny >= C) {
                    nx -= dir[d][0];
                    ny -= dir[d][1];
                    if(d % 2 == 0) {
                        d += 1;
                    } else {
                        d -= 1;
                    }
                    nx += dir[d][0];
                    ny += dir[d][1];
                }
            }
//
//            int dx = p.r;
//            int dy = p.c;
//            int d = p.d;
//            for (int j = 0; j < p.s; j++) {
//                int nx = dx + dir[d][0];
//                int ny = dy + dir[d][1];
//                if(nx < 0 || nx>=R || ny < 0 || ny>=C) {
//                    j--;
//                    d = d == 0 ? 1 : d == 1 ? 0 : d == 2 ? 3 : 2;
//                    continue;
//                }
//                dx = nx;
//                dy = ny;
//            }
            q.add(new Shark(p.n,nx,ny,p.s,d,p.z));
        }
    }

    private static void print() {
        for (Shark s : q) {
            System.out.println(s);
        }
        System.out.println();
    }
}