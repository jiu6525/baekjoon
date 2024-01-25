import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int ans = 0;
        for(int i=1; i<=n; i++){
            for(int j=i; j<=n; j++){
                if(i*j<=n){
                    ans += 1;
                }else{
                    break;
                }
            }
        }
        System.out.println(ans);

    }
}