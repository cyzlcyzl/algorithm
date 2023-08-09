import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static Stack<Character> left, right;

    static void L(){
        if(! left.isEmpty()) right.push(left.pop());
    }

    static void D(){
        if(! right.isEmpty()) left.push(right.pop());
    }

    static void B(){
        if(! left.isEmpty()) left.pop();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        left = new Stack<>();
        right = new Stack<>();
        for(char i : input) left.push(i);

        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i<M; i++){
            String comm = br.readLine();
            int len = comm.length();

            if(len>1){
                // P
                left.push(comm.charAt(2));
            }else{
                // L, D, B
                if(comm.charAt(0) == 'L') L();
                else if (comm.charAt(0) == 'D') D();
                else if (comm.charAt(0) == 'B') B();
            }
        }
        while(! left.isEmpty()) right.push(left.pop());

        StringBuilder sb = new StringBuilder();
        while(! right.isEmpty()) sb.append(right.pop());
        System.out.println(sb);
    }
}
