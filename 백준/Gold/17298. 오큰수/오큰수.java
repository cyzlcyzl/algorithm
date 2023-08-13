import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        int[] num = new int[N];
        for(int i = 0; i<N; i++) num[i] = Integer.parseInt(st.nextToken());

        int[] ans = new int[N];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i<N; i++){
            while (!stack.isEmpty() && num[i]>num[stack.peek()]){
                ans[stack.peek()] = num[i];
                stack.pop();
            }
            stack.push(i);
        }

        while(!stack.isEmpty()) ans[stack.pop()] = -1;

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i : ans) bw.write(i + " ");


        bw.flush();
        bw.close();

    }
}