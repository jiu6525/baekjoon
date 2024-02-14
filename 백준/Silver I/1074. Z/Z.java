import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int cnt,n,r,c;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        n = (int)Math.pow(2,n);
        cnt = 0;

        rc(0,0,n);

        System.out.println(cnt);
    }

    private static void rc(int x, int y, int k) {
        if(k==2){
            L:for (int i = x; i < x+k; i++) {
                for (int j = y; j < y+k; j++) {
                    if(r==i && c==j){
                        break L;
                    }
                    cnt++;
                }
            }
            return;
        }

        int k2 = k/2;

        if(x<=r && r<x+k2 && y<=c && c<y+k2){
            rc(x,y,k2);
        } else if (x<=r && r< x+k2 && y+k2 <= c && c < y+k) {
            cnt += k2*k2;
            rc(x,y+k2,k2);
        } else if (x+k2<=r && r<x+k && y<=c && c<y+k2) {
            cnt += (k2*k2)*2;
            rc(x+k2,y,k2);
        } else if (x+k2<=r && r<x+k && y+k2<=c && c<y+k) {
            cnt += (k2*k2)*3;
            rc(x+k2,y+k2,k2);
        }
    }
}

//3 5 9