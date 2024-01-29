import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int fibo = fibo(n);
        System.out.println(fibo);
    }

    private static int fibo(int n) {
        if(n == 0){
            return 0;
        }
        if(n <= 2){
            return 1;
        }
        return fibo(n-2) + fibo(n-1);
    }
}
