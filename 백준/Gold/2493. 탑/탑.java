import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static class Top {
        int height;
        int idx;

        Top(int height, int idx) {
            this.height = height;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Stack<Top> top = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(st.nextToken());

            while (!top.isEmpty()) {
                if (now < top.peek().height) {
                    sb.append(top.peek().idx).append(" ");
                    break;
                } else {
                    top.pop();
                }
            }
            if (top.isEmpty()) sb.append(0).append(" ");
            top.push(new Top(now, i + 1));

        }
            System.out.println(sb);
    }
}