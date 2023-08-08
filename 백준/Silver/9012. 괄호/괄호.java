import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static void VPS(String[] arr){
        Stack<String> stack = new Stack<>();

        for(int i = 0; i<arr.length; i++){
            if(stack.isEmpty() && arr[i].equals(")")) {
                sb.append("NO").append("\n");
                return;
            }
            else {
                if(stack.isEmpty()) stack.push(arr[i]);
                else if (stack.peek().equals(arr[i])) stack.push(arr[i]);
                else if (! stack.peek().equals(arr[i])) stack.pop();
            }
        }
            if(stack.isEmpty()) sb.append("YES").append("\n");
            else sb.append("NO").append("\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i<T; i++){
            String[] input = br.readLine().split("");
            VPS(input);
        }
        br.close();

        sb.setLength(sb.length()-1);
        System.out.println(sb);

    }
}
