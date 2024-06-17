import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 1. 끝나는 시간이 가장 작은 것부터 시작
    // 2. 시작 시간은 이전 끝나는 시간보다 크거나 같은 수 && 끝나는 시간이 작은 순으로 배치

    int N = Integer.parseInt(br.readLine());
    int[][] timeTable = new int[N][2];
    for (int i = 0; i < N; i++) {
      String[] input = br.readLine().split(" ");
      timeTable[i][0] = Integer.parseInt(input[0]);
      timeTable[i][1] = Integer.parseInt(input[1]);
    }

    Arrays.sort(timeTable, (o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]); // 끝나는 시간 작은 순으로 정렬

    int cnt = 1;
    int check = 0;
    for (int i = 0; i<N-1; i++) {
      if (timeTable[i+1][0] < timeTable[check][1]) continue;
      cnt++;
      check = i+1;
    }

    System.out.println(cnt);
  }
}
