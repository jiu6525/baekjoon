import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int R, C;
    private static Node[] swan;
    private static char[][] map;
    private static Queue<Node> queue, waterQueue;
    private static boolean[][] visited;
    private static final int[] dr = { -1, 1, 0, 0 };
    private static final int[] dc = { 0, 0, -1, 1 };
    private static int day = 0;
    static class Node {
        int r, c;
        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    private static void waterBFS() {
        // 한 번만 녹여야 하므로, 현재 큐 사이즈만큼만 돌린다.
        int waterSize = waterQueue.size();
        while (waterSize-- > 0) {
            Node now = waterQueue.poll();
            for (int i = 0; i < 4; i++) {
                int nextR = now.r + dr[i];
                int nextC = now.c + dc[i];
                if (nextR >= R || nextR < 0 || nextC >= C || nextC < 0) continue;
                if (map[nextR][nextC] == 'X') {
                    map[nextR][nextC] = '.';
                    waterQueue.offer(new Node(nextR, nextC));
                }
            }
        }
    }
    private static void BFS() {
        boolean meet = false;
        while (true) {
            Queue<Node> nextQueue = new LinkedList<>();
            while (!queue.isEmpty()) {
                Node now = queue.poll();
                if (now.r == swan[1].r && now.c == swan[1].c) {
                    meet = true;
                    break;
                }
                for (int i = 0; i < 4; i++) {
                    int nextR = now.r + dr[i];
                    int nextC = now.c + dc[i];
                    if (nextR >= R || nextR < 0 || nextC >= C || nextC < 0 || visited[nextR][nextC]) continue;
                    visited[nextR][nextC] = true;
                    if (map[nextR][nextC] == 'X') {
                        nextQueue.offer(new Node(nextR, nextC));
                        continue;
                    }
                    queue.offer(new Node(nextR, nextC));
                }
            }
            if (meet) break;
            queue = nextQueue;
            waterBFS();
            day++;
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        swan = new Node[2];
        queue = new LinkedList<>();
        waterQueue = new LinkedList<>();
        visited = new boolean[R][C];

        int swanIndex = 0;
        for (int i = 0; i < R; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                map[i][j] = line[j];
                if(map[i][j] == 'L') {
                    swan[swanIndex++] = new Node(i, j);
                }
                if(map[i][j] != 'X') {
                    waterQueue.offer(new Node(i, j));
                }
            }
        }
        queue.offer(swan[0]);
        visited[swan[0].r][swan[0].c] = true;
        BFS();
        System.out.println(day);
    }
}