import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] parent;
    public static int find(int node){
        if(node==parent[node]) return node;
        return parent[node] = find(parent[node]);
    }

    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a!=b){
            if(a<b) parent[b] = a;
            else parent[a] = b;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N+1];
        for(int i = 0; i<=N; i++) parent[i] = i;

        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 0으로 시작하면 연결 // 1로 시작하면 같은 집합에 있는지 출력
            if(first==0) union(a, b);
            else if (first==1) {
                if(find(a)==find(b)) sb.append("YES").append("\n");
                else sb.append("NO").append("\n");
            }
        }

        sb.setLength(sb.length()-1);
        System.out.println(sb);

    }
}
