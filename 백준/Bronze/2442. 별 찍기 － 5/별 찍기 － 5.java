import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
//        int n = 5;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j<2*n;j++) {
                if(n-i<=j && j<=n+i){
                    System.out.print("*");
                }else if(n+i<j){
                    break;
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

    }
}
