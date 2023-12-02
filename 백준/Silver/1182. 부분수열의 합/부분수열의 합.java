import java.util.*;
import java.io.*;

public class Main{
    
    static int N, S;
    static int[] arr;
    static boolean[] isVisited;
    
    static int subset(int depth){
        if(depth == N){
            int sum = 0;
            for(int i = 0; i<arr.length; i++){
                if(! isVisited[i]) continue;
                sum += arr[i];
            }
            if(sum == S) return 1;
            return 0;
        }
        
        isVisited[depth] = true;
        int case1 = subset(depth + 1);
        isVisited[depth] = false;
        int case2 = subset(depth + 1);
        
        return case1 + case2;
    }
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		isVisited = new boolean[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		int answer = subset(0);
		if(S == 0) answer--;
		System.out.println(answer);
	}
}
