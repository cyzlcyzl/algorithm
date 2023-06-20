import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] arr = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		String input = br.readLine();
		
		br.close();

		
			for(int i = 0; i<arr.length; i++) {
				while(input.contains(arr[i])) {
					input = input.replaceFirst(arr[i], "a");
				}
			}
		
			bw.write(input.length()+"");
			
			bw.flush();
			bw.close();
			
	}

}