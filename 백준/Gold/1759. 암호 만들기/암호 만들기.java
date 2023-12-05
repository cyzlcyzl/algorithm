import java.io.*;
import java.util.*;

public class Main{
    
    static int L, C;
    static char[] alphabet;
    static int[] select;
    static boolean[] isVisited;
    static StringBuilder sb = new StringBuilder();
    
    static void dfs(int depth, int idx){
        if(depth == L){
            if(! checkAEIOU(select)) return;
            
            for(int i = 0; i<L; i++){
                sb.append(alphabet[select[i]]);
            }
            sb.append("\n");
            return;
        }
        
        for(int i = idx; i<C; i++){
            if(isVisited[i]) continue;
            select[depth] = i;
            isVisited[i] = true;
            dfs(depth + 1, i + 1);
            isVisited[i] = false;
        }
    }
    
    static boolean checkAEIOU(int[] select){
        List<Character> aeiou = Arrays.asList('a', 'e', 'i', 'o', 'u');
        int cnt = 0;
        for(int i = 0; i<select.length; i++){
            char c = alphabet[select[i]];
            if(aeiou.contains(c)) cnt++;
        }
        
        if(cnt == 0 || cnt >= L-1) return false;
        return true;
    }
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		alphabet = new char[C];
		isVisited = new boolean[C];
		select = new int[L];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i<C; i++) alphabet[i] = st.nextToken().charAt(0);
		Arrays.sort(alphabet);
		
		dfs(0, 0);
		
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
}
