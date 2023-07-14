import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static int N;
    static int M; // 선택 개수
    static int[] select;
    static boolean[] isSelected;

    public static void combination(int idx, int size) throws IOException {
        // 종료 조건
        if(size == M){
            for(int i = 0; i<M; i++) System.out.print(arr[select[i]] + " ");
            System.out.println();
            return;
        }

        // 재귀
        for(int i = idx; i<N; i++){
            if(isSelected[i]) continue;

            select[size] = i;
            isSelected[i] = true;
            combination(i, size+1);

            isSelected[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        select = new int[N];
        isSelected = new boolean[N];
        for(int i = 0; i<N; i++) arr[i] = i+1;

        combination(0, 0);



    }
}
