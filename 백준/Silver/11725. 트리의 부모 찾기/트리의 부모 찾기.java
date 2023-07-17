import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static ArrayList<Integer>[] tree;
    static boolean[] isVisited;
    static int[] whoParents;

    public static void treeParent(int num) {

        for (int i : tree[num]) {
            if (whoParents[i] == 0){
                whoParents[i] = num;
                treeParent(i);
            }

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        tree = new ArrayList [N + 1];
        isVisited = new boolean[N+1];
        whoParents = new int[N + 1];

        for(int i = 0; i<tree.length; i++) tree[i] = new ArrayList<>();

        for(int i = 0; i<N-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            tree[u].add(v);
            tree[v].add(u);
        }

        // 루트 노드 1
        treeParent(1);

        StringBuilder sb = new StringBuilder();
        for(int i = 2; i<whoParents.length; i++) sb.append(whoParents[i]).append("\n");

        sb.setLength(sb.length()-1);
        System.out.println(sb);

    }
}
