import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M, virus;
    static ArrayList<Integer>[] computer;
    static boolean[] isVisited;
    static void dfs(int node){
        for(int i : computer[node]){
            if(isVisited[i]) continue;
            virus++;
            isVisited[i] = true;
            dfs(i);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        computer = new ArrayList[N+1];
        isVisited = new boolean[N+1];
        for(int i = 0; i<computer.length; i++) computer[i] = new ArrayList<>();
        for(int i = 0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            computer[u].add(v);
            computer[v].add(u);
        }
        isVisited[1] = true;
        virus = 0;
        dfs(1);
        
        System.out.println(virus);
    }
}
