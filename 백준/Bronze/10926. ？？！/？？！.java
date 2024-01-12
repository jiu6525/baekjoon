import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Main{	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String a = br.readLine();
		System.out.printf("%s??!",a);
		br.close();
		}
}
