import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Integer> line = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i<N; i++) line.add(Integer.parseInt(st.nextToken()));

        Stack<Integer> waiting = new Stack<>();
        int find = 0;
        for(int num : line) {
            while (! waiting.isEmpty() && waiting.peek().equals(find + 1)) {
                waiting.pop();
                find++;
            }
            waiting.add(num);
        }

        while (! waiting.isEmpty() && waiting.peek().equals(find + 1)) {
            waiting.pop();
            find++;
        }

        if (waiting.isEmpty()) System.out.println("Nice");
        else System.out.println("Sad");
    }
}
