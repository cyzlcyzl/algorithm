import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Set<String> unHeared = new HashSet<>();
		
		for(int i = 0; i<N; i++){
		    unHeared.add(br.readLine());
		}
		
		List<String> unHearedAndLooked = new ArrayList<>();
		
		for(int i = 0; i<M; i++){
		    String input = br.readLine();
		    if(unHeared.contains(input)) unHearedAndLooked.add(input);
		}
		
		Collections.sort(unHearedAndLooked);
		StringBuilder sb = new StringBuilder();
		sb.append(unHearedAndLooked.size()).append("\n");
		
		for(String name : unHearedAndLooked){
		    sb.append(name).append("\n");
		}
		
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
}