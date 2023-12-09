import java.util.*;
import java.io.*;

public class Main{
    
    static int n, m;
    static ArrayList<Integer>[] friends;
    static boolean[] isVisited;
    static int cnt;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		friends = new ArrayList[n+1];
		isVisited = new boolean[n+1];
		for(int i = 0; i<friends.length; i++) friends[i] = new ArrayList<>();
		for(int i = 0; i<m; i++){
		    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		    int u = Integer.parseInt(st.nextToken());
		    int v = Integer.parseInt(st.nextToken());
		    friends[u].add(v);
		    friends[v].add(u);
		}
		
		isVisited[1] = true;
		for(int next : friends[1]) isVisited[next] = true;
		cnt = friends[1].size();
		
		if(cnt > 0) {
		    for(int next : friends[1]) {
		        for(int nnext : friends[next]){
		            if(isVisited[nnext]) continue;
		            isVisited[nnext] = true;
		            cnt++;
		        }
		    }
		}
		
		System.out.println(cnt);
	}
}
