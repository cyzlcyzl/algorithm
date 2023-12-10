import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        int[] D = new int[n + 1];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            D[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < k; i++) {
            int[] temp = new int[n+1];
            for (int j = 1; j <= n; j++) {
                temp[D[j]] = arr[j];
            }
            arr = temp;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) sb.append(arr[i]).append(" ");
        System.out.println(sb);

    }

}