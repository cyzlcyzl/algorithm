import java.io.*;
import java.util.*;

public class Main{
    
    static int N, M;
    static boolean[] isVisited;
    static int[] arr, select;
    static Set<String> set = new LinkedHashSet<>();
    
    static void combination(int idx, int size){
        if(size == M){
            String s = "";
            for(int i = 0; i<M; i++) s += arr[select[i]] + " ";
            set.add(s);
            return;
        }
        
        for(int i = idx; i<N; i++){
            if(isVisited[i]) continue;
            select[size] = i;
            isVisited[i] = true;
            combination(idx, size + 1);
            isVisited[i] = false;
        }
    }
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		isVisited = new boolean[N];
		select = new int[M];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		combination(0, 0);
		
		StringBuilder sb = new StringBuilder();
		for(String s : set) sb.append(s).append("\n");
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
}
