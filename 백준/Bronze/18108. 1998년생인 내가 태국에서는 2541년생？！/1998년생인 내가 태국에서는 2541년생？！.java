import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Main{	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int a = Integer.parseInt(br.readLine());
		System.out.printf("%d",a-543);
		br.close();
		}
}
