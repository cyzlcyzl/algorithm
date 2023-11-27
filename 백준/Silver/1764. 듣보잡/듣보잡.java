import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Set<String> unLooked = new HashSet<>();
		for(int i = 0; i<N; i++) unLooked.add(br.readLine());
		
		List<String> unLookedAndunHeared = new ArrayList<>();
		for(int i = 0; i<M; i++){
		    String name = br.readLine();
		    if(unLooked.contains(name)) unLookedAndunHeared.add(name);
		}
		
		Collections.sort(unLookedAndunHeared);
		
		StringBuilder sb = new StringBuilder();
		sb.append(unLookedAndunHeared.size()).append("\n");
		for(String name : unLookedAndunHeared) {
		    sb.append(name).append("\n");
		}
		
		sb.setLength(sb.length()-1);
		System.out.println(sb);
		
	}
}
