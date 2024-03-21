import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n, block[][], greenRIdx[], blueRIdx[], score, cellCnt;
    static boolean green[][], blue[][];

    public static void main(String[] args) throws NumberFormatException, IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        green = new boolean[6][4];
        blue = new boolean[6][4];
        block = new int[n][3];
        greenRIdx = new int[4];
        blueRIdx = new int[4];

        for (int idx = 0; idx < 4; idx++) {
            greenRIdx[idx] = 6;
            blueRIdx[idx] = 6;
        }

        for (int idx = 0; idx < n; idx++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            block[idx][0] = t;
            block[idx][1] = x;
            block[idx][2] = y;
        }
        // 블럭 하강
        // 행 체크 및 점수 추가
        // 연한칸 체크
        // rIdx 체크

        for (int blockIdx = 0; blockIdx < n; blockIdx++) {
            checkBlock(block[blockIdx][0], block[blockIdx][1], block[blockIdx][2]);

            checkArea();

            checkLightColorArea();

            updateRIdx();
        }

        // 모든 칸 체크
        checkResultArea();

        System.out.println(score);
        System.out.println(cellCnt);
    }

    private static void checkResultArea() {
        for (int r = 2; r < 6; r++) {
            for (int c = 0; c < 4; c++) {
                if (green[r][c]) ++cellCnt;
                if (blue[r][c]) ++cellCnt;
            }
        }

    }

    private static void updateRIdx() {

        Arrays.fill(greenRIdx, 6);
        Arrays.fill(blueRIdx, 6);
        for (int c = 0; c < 4; c++) {
            for (int rIdx = 5; rIdx >= 0; rIdx--) {
                if (green[rIdx][c]) greenRIdx[c] = rIdx;
                if (blue[rIdx][c]) blueRIdx[c] = rIdx;
            }
        }
    }

    private static void checkLightColorArea() {
        // 초록색 영역 체크
        int cnt = 0;
        for (int r = 0; r <= 1; r++) {
            for (int c = 0; c < 4; c++) {
                if (green[r][c]) {
                    ++cnt;
                    break;
                }
            }
        }

        for (int rIdx = 5; rIdx >= cnt; rIdx--) {
            green[rIdx] = green[rIdx-cnt].clone();
        }
        Arrays.fill(green[0], false);
        if (cnt == 2) {
            Arrays.fill(green[1], false);
        }

        // 파란색 영역 체크
        cnt = 0;
        for (int r = 0; r <= 1; r++) {
            for (int c = 0; c < 4; c++) {
                if (blue[r][c]) {
                    ++cnt;
                    break;
                }
            }
        }

        for (int rIdx = 5; rIdx >= cnt; rIdx--) {
            blue[rIdx] = blue[rIdx-cnt].clone();
        }
        Arrays.fill(blue[0], false);
        if (cnt == 2) {
            Arrays.fill(blue[1], false);
        }
    }

    private static void checkArea() {
        // 초록색 영역 체크
        for (int r = 0; r < 6; r++) {
            int cnt = 0;
            for (int c = 0; c < 4; c++) {
                if (green[r][c]) {
                    ++cnt;
                }
            }

            if (cnt != 4)
                continue;

            ++score;
            // 행 없애고 모든 블럭 아래로 땡기기
            for (int cur = r; cur > 0; cur--) {
                green[cur] = green[cur - 1].clone();
            }
            Arrays.fill(green[0], false);
        }

        // 파란색 영역 체크
        for (int r = 0; r < 6; r++) {
            int cnt = 0;
            for (int c = 0; c < 4; c++) {
                if (blue[r][c]) {
                    ++cnt;
                }
            }

            if (cnt != 4)
                continue;

            ++score;
            // 행 없애고 모든 블럭 아래로 땡기기
            for (int cur = r; cur > 0; cur--) {
                blue[cur] = blue[cur - 1].clone();
            }
            Arrays.fill(blue[0], false);
        }
    }

    private static void checkBlock(int t, int r, int c) {
        if (t == 1) {
            // 초록색 체크 => c 체크
            int g_rIdx = greenRIdx[c];
            green[g_rIdx-1][c] = true;

            // 파란색 => r 체크
            int b_rIdx = blueRIdx[3-r];
            blue[b_rIdx-1][3-r] = true;
        } else if (t == 2) {
            // 초록색 체크 => c 체크
            int gf_rIdx = greenRIdx[c];
            int gb_rIdx = greenRIdx[c + 1];

            if (gf_rIdx < gb_rIdx) {
                green[gf_rIdx-1][c] = true;
                green[gf_rIdx-1][c+1] = true;
            } else {
                green[gb_rIdx-1][c] = true;
                green[gb_rIdx-1][c+1] = true;
            }

            // 파란색 => r 체크
            int b_rIdx = blueRIdx[3-r];
            blue[b_rIdx-1][3-r] = true;
            blue[b_rIdx-2][3-r] = true;
        } else if (t == 3) {
            // 초록색 체크 => c 체크
            int g_rIdx = greenRIdx[c];
            green[g_rIdx-1][c] = true;
            green[g_rIdx-2][c] = true;

            // 파란색 => r 체크
            int bf_rIdx = blueRIdx[3-r];
            int bb_rIdx = blueRIdx[3-r-1];

            if (bf_rIdx < bb_rIdx) {
                blue[bf_rIdx-1][3-r] = true;
                blue[bf_rIdx-1][3-r-1] = true;
            } else {
                blue[bb_rIdx-1][3-r] = true;
                blue[bb_rIdx-1][3-r-1] = true;
            }
        }
    }

}