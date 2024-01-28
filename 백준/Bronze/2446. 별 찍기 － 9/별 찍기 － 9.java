import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
//        int n = 5;
        int cnt = 0;

        for(int i = 0; i<2*n-1; i++){
            for(int j = 0; j<2*n-1;j++){
                if(cnt>j ){
                    System.out.print(" ");
                } else if (j>=2*n-cnt-1) {
                    break;
                } else{
                    System.out.print("*");
                }
            }
            System.out.println();

            if(i<n-1){
                cnt++;
            }else{
                cnt--;
            }
        }
    }
}

