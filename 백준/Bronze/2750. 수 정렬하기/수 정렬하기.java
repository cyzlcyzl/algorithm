import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for(int i = 0; i<arr.length; i++) arr[i] = Integer.parseInt(br.readLine());
        br.close();

        // 선택정렬
        for(int i = 0; i<N-1; i++){
        int minIdx = i;
            for(int k = i+1; k<N; k++){
                if(arr[minIdx]>arr[k]) minIdx = k;
            }
                change(arr, minIdx, i);
        }

        StringBuilder sb = new StringBuilder();
        for(int i : arr) sb.append(i).append("\n");

        sb.setLength(sb.length() - 1);
        System.out.println(sb);

    }

    public static void change(int[] arr, int i, int k){
        int temp = arr[i];
        arr[i] = arr[k];
        arr[k] = temp;
    }

}
