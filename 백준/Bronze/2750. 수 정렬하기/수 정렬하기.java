import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void change(int[] arr, int i, int k){
        int temp = arr[i];
        arr[i] = arr[k];
        arr[k] = temp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for(int i = 0; i<arr.length; i++) arr[i] = Integer.parseInt(br.readLine());
        br.close();

        // 버블정렬
        for(int i = 0; i<arr.length; i++){
            for(int k = 0; k<i; k++){
                if(arr[i]<arr[k]) change(arr, i, k);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i : arr) sb.append(i).append("\n");

        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
}
