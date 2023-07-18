import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static ArrayList<Integer>[] tree;
    static StringBuilder pre = new StringBuilder();
    static StringBuilder in = new StringBuilder();
    static StringBuilder post = new StringBuilder();
    public static void preorder(int now){
        pre.append((char)(now+65));
        if(tree[now].get(0) != - 19) preorder(tree[now].get(0));
        if(tree[now].get(1) != - 19) preorder(tree[now].get(1));
    }
    public static void inorder(int now){
        if(tree[now].get(0) != - 19) inorder(tree[now].get(0));
        in.append((char)(now+65));
        if(tree[now].get(1) != - 19) inorder(tree[now].get(1));
    }
    public static void postorder(int now){
        if(tree[now].get(0) != - 19) postorder(tree[now].get(0));
        if(tree[now].get(1) != - 19) postorder(tree[now].get(1));
        post.append((char)(now+65));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N];
        for(int i = 0; i<tree.length; i++) tree[i] = new ArrayList<>();

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int idx = st.nextToken().charAt(0) - 65;
            for(int k = 0; k<2; k++){
                int child = st.nextToken().charAt(0) - 65;
                tree[idx].add(child);
            }
        }
        preorder(0);
        inorder(0);
        postorder(0);

        pre.append("\n").append(in).append("\n").append(post);
        System.out.println(pre);

    }
}
