import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static int n;

  public static int fibonacci(int a, int b, int depth) {
    if (n == depth) return b;
    return fibonacci(b, a+b, depth + 1);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n =Integer.parseInt(br.readLine());

    int result = fibonacci(0, 1, 1);
    System.out.println(result);
  }
}