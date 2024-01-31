import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            for(int j = 0; j<n; j++){
                star(i,j,n);
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }
    private static void star(int i, int j, int n) {
        if(i%3==1 && j%3==1){
            sb.append(" ");
        }else{
            if(n==1){
                sb.append("*");

            }else{
                star(i/3,j/3,n/3);
            }
        }
    }
}