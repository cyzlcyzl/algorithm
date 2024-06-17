import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
  public static boolean isBalanced(String input) {
    Stack<Character> stack = new Stack<>();

    for (int i = 0; i<input.length(); i++) {
      char c = input.charAt(i);

      if (c == '(') stack.push(c);
      else if (c == ')') {
        if (! stack.isEmpty() && stack.peek() == '(') {
          stack.pop();
          continue;
        }
        stack.push(c);
      }

      if (c == '[') stack.push(c);
      else if (c == ']') {
        if (! stack.isEmpty() && stack.peek() == '[') {
          stack.pop();
          continue;
        }
        stack.push(c);
      }
    }

    return stack.isEmpty();
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    while (true) {
      String input = br.readLine();
      if (input.equals(".")) break;

      if (isBalanced(input)) System.out.println("yes");
      else System.out.println("no");
    }
  }
}