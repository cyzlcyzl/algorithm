import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i<N; i++){
            String[] input = br.readLine().split(" ");

            if(input.length == 2){
                // push
                stack.push(Integer.parseInt(input[1]));
            }else{
                // 그 외
                if(input[0].equals("top")){
                    if(stack.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(stack.peek()).append("\n");
                } else if (input[0].equals("pop")) {
                    if (stack.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(stack.pop()).append("\n");
                } else if (input[0].equals("size")) sb.append(stack.size()).append("\n");
                else if (input[0].equals("empty")){
                    if(stack.isEmpty()) sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                }
            }
        }
        br.close();
        if(sb.length()>0) sb.setLength(sb.length()-1);
        System.out.println(sb);
    }
}
