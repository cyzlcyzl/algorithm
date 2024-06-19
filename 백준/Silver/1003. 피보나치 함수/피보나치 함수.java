import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static int[][] memo;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());
    memo = new int[41][2]; // n <= 40

    memo[0][0] = 1; memo[0][1] = 0;
    memo[1][0] = 0; memo[1][1] = 1;

    for(int i = 2; i<41; i++) {
      memo[i][0] = memo[i-2][0] + memo[i-1][0];
      memo[i][1] = memo[i-2][1] + memo[i-1][1];
    }

    StringBuilder sb = new StringBuilder();
    for(int i = 0; i<T; i++) {
      int N = Integer.parseInt(br.readLine());

      sb.append(memo[N][0]).append(" ").append(memo[N][1]).append("\n");
    }
    sb.setLength(sb.length()-1);
    System.out.println(sb);

  }
}