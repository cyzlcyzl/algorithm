import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr, select;
    static boolean[] isSelected;
    static StringBuilder sb = new StringBuilder();

    static void lotto(int size, int idx){
        if(size==6){
            for(int i = 0; i<select.length; i++){
                sb.append(arr[select[i]]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = idx; i<arr.length; i++){
            if(isSelected[i]) continue;

            select[size] = i;
            isSelected[i] = true;
            lotto(size+1, i);
            isSelected[i] = false;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            if(k==0) break;

            arr = new int[k];
            select = new int[6];
            isSelected = new boolean[k];

            for(int i = 0; i<k; i++) arr[i] = Integer.parseInt(st.nextToken());
            Arrays.toString(arr);
            lotto(0, 0);
            
            System.out.println(sb);
            sb = new StringBuilder();

        }

    }
}
