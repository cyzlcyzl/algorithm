import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int[] arr, select;
    static boolean[] isSelected;
    static StringBuilder sb = new StringBuilder();

    static void permutation(int size){
        // 종료 조건
        if(size == N){
            for(int i = 0; i<select.length; i++){
                sb.append(arr[select[i]]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i<arr.length; i++){
            if(isSelected[i]) continue;

            select[size] = i;
            isSelected[i] = true;
            permutation(size+1);
            isSelected[i] = false;

        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        select = new int[N];
        isSelected = new boolean[N];
        arr = new int[N];
        for(int i = 0; i<arr.length; i++) arr[i] = i+1;

        // 순열
        permutation(0);

        // 출력
        sb.setLength(sb.length()-1);
        System.out.println(sb);
        
    }
}
