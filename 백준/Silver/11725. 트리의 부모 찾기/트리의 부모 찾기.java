import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static ArrayList<Integer>[] tree;
    static boolean[] isVisited;
    static int[] parents;

    public static void parent(int now){
        for(int i : tree[now]){
            if(isVisited[i]) continue;
            isVisited[i] = true;
            parents[i] = now;
            parent(i);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N+1];
        isVisited = new boolean[N+1];
        parents = new int[N+1];
        for(int i = 0; i< tree.length; i++) tree[i] = new ArrayList<>();
        for(int i = 0; i<N-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree[u].add(v);
            tree[v].add(u);
        }

        isVisited[1] = true;
        parent(1);

        StringBuilder sb = new StringBuilder();
        for(int i = 2; i<=N; i++) sb.append(parents[i]).append("\n");
        sb.setLength(sb.length()-1);
        System.out.println(sb);
    }
}
