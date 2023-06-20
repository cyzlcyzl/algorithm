import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[][] inputArr = new String[5][15];
		


		for (int i = 0; i < 5; i++) {
			String input = br.readLine();
			for(int k = 0; k<input.length(); k++) {
				inputArr[i][k] = input.substring(k, k+1);
			}
		}

		
		for (int i = 0; i < inputArr[0].length; i++) {
			for (int k = 0; k < 5; k++) {
				if(inputArr[k][i] == null) {
					bw.write("");
				}else {					
					bw.write(inputArr[k][i] + "");
				}
			}
		}

		br.close();
		bw.flush();
		bw.close();
	}
}
