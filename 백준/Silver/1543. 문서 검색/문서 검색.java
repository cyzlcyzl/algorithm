import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String doc = br.readLine();
		String search = br.readLine();
		
		int len = search.length();
		int answer = 0;
		
		while(doc.length() > len){
		    String cut = doc.substring(0, len);
		    if(cut.equals(search)) {
		        answer++;
		        doc = doc.substring(len);
		    }
		    else {
		        doc = doc.substring(1);
		    }
		}
		
		if(doc.length() == len && doc.equals(search)) answer++;
		
		System.out.println(answer);
	}
}
