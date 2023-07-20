import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr, select;
    static boolean[] isSelected;
    static StringBuilder sb = new StringBuilder();
    public static void sequence(int cnt){
        if(cnt == M){
            for(int i = 0; i< select.length; i++){
                sb.append(arr[select[i]]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = 0; i<arr.length; i++){
            if(isSelected[i]) continue;
            select[cnt] = i;
            isSelected[i] = true;
            sequence(cnt+1);
            isSelected[i] = false;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        isSelected = new boolean[N];
        select = new int[M];
        for(int i = 0; i<arr.length; i++) arr[i] = i+1;

        sequence(0);
        sb.setLength(sb.length()-1);
        System.out.println(sb);
    }
}
