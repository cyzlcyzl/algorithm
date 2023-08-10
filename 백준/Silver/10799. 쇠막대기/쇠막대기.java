import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String stick = br.readLine();

        Stack<Character> stack = new Stack<>();
        int cnt = 0;
        for(int i = 0; i<stick.length(); i++){
            if(stick.charAt(i) == '(') stack.push(stick.charAt(i));
            else{
                if(stick.charAt(i-1)=='(' && stick.charAt(i) == ')') {
                   stack.pop();
                   cnt += stack.size();
                }
                else if (stick.charAt(i) == ')') {
                    stack.pop();
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
