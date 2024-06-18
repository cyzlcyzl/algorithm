import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static StringBuilder line;

  public static void cantor(int start, int len) {
    if (len == 1) return;

    int nextLen = len / 3;
    for (int i = start + nextLen; i < start + nextLen * 2; i++) line.setCharAt(i, ' ');

    cantor(start, nextLen);
    cantor(start + nextLen * 2, nextLen);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String input;
    while ((input = br.readLine()) != null) {
      int N = (int)  Math.pow(3, Integer.parseInt(input));

      line = new StringBuilder();
      for (int i = 0; i<N; i++) line.append('-');
      cantor(0, N);

      System.out.println(line);
    }
  }
}