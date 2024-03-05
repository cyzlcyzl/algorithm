import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String doc = br.readLine();
		String search = br.readLine();
		
		doc = doc.replace(search, "1");
		int answer = 0;
		for(int i = 0; i<doc.length(); i++){
		    if(doc.charAt(i) == '1') answer++;
		}
		
		System.out.println(answer);
	}
}