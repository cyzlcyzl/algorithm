import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{

    static int N;
    static ArrayList<Integer>[] tree;
    static int root;
    static int remove;
    static int count;

    static void dfs(int node){
        if(node == remove) return;
        if(tree[node].size() == 0) count++;
        for(int n : tree[node]) dfs(n);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N];
        for(int i = 0; i<tree.length; i++) tree[i] = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i<tree.length; i++){
            int parent = Integer.parseInt(st.nextToken());
            if(parent == -1) {
                root = i;
                continue;
            }
            tree[parent].add(i);
        }
        remove = Integer.parseInt(br.readLine());
        count = 0;
        if(root != remove){
            for(int i = 0; i<tree.length; i++) tree[i].remove(Integer.valueOf(remove));
            dfs(root);
        }
        System.out.println(count);
    }
}