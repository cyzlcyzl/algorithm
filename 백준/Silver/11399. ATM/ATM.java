import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 필요한 시간이 짧은 순서대로 정렬하여 누적합의 총합

    int N = Integer.parseInt(br.readLine());
    int[] time = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i<N; i++) time[i] = Integer.parseInt(st.nextToken());

    Arrays.sort(time);

    int[] timeSum = new int[N];
    timeSum[0] = time[0];
    for(int i = 1; i<N; i++) timeSum[i] = timeSum[i-1] + time[i];

    int result = 0;
    for (int i = 0; i<N; i++) result += timeSum[i];
    System.out.println(result);
  }
}