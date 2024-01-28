import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int cnt = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<=n+cnt; j++){
                if(j == n-cnt-1 || j == n + cnt-1){
                    System.out.print("*");
                }else {
                    System.out.print(" ");
                }
            }
            System.out.println();
                cnt++;
        }

    }
}

