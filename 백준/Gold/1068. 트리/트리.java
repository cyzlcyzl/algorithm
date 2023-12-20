import java.io.*;
import java.util.*;

public class Main{
    
    static int N;
    static ArrayList<Integer>[] tree;
    static int root, removeNum;
    static int cnt = 0;
    
    static void dfs(int start){
        if(start == removeNum) return;
        if(tree[start].size() == 0) cnt++;
        for(int next : tree[start]) dfs(next);
    }
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		tree = new ArrayList[N];
		for(int i = 0; i<N; i++) tree[i] = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i<N; i++){
		    int p = Integer.parseInt(st.nextToken());
		    if(p != -1) tree[p].add(i);
		    else root = i;
		}
		
		removeNum = Integer.parseInt(br.readLine());
		
		if(root != removeNum){
		    for(int i = 0; i<N; i++) tree[i].remove(Integer.valueOf(removeNum));
		    dfs(root);
		}
		System.out.println(cnt);
	}
}
