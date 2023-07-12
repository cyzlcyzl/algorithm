import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i<n; i++) stack.push(Integer.parseInt(br.readLine()));

        Stack<Integer> res = new Stack<>();

        int push = 1;
        int pop = 0;
        for(int i = 0; i<n; i++){
            while(pop != stack.get(i)){
                if(res.isEmpty() || ! res.peek().equals(stack.get(i))){
                    res.push(push++);
                    if(push>n+1){
                        sb.setLength(0);
                        sb.append("NO").append("\n");
                        break;
                    }
                    sb.append("+").append("\n");
                }else if(stack.get(i).equals(res.peek())){
                    pop = res.pop();
                    sb.append("-").append("\n");
                }
            }
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);


    }
}
