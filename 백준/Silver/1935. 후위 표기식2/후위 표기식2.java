import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] postfix = br.readLine().toCharArray();
        String[] num = new String[N];
        for(int i = 0; i<num.length; i++) num[i] = br.readLine();
        br.close();
        
        Stack<Double> stack = new Stack<>();
        double cal = 0;
        for(int i = 0; i<postfix.length; i++){
            if(postfix[i] != '+' && postfix[i] != '-' && postfix[i] != '*' && postfix[i] != '/'){
                double push = Double.parseDouble(num[postfix[i]-65]);
                stack.push(push);
                continue;
            }
            double a = stack.pop();
            double b = stack.pop();
            if(postfix[i] == '+') cal = b+a;
            else if (postfix[i] == '-') cal = b-a;
            else if (postfix[i] == '*') cal = b*a;
            else if (postfix[i] == '/') cal = b/a;
            stack.push(cal);
        }
        System.out.println(String.format("%.2f", cal));
    }
}

