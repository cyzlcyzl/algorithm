import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] A;

    public static int isExist(int i){
        int low = 0;
        int high = N-1;
        int mid = (low + high)/ 2;
        while(low<=high){
            mid = (low + high)/ 2;
            if(A[mid] == i) return 1;
            else if (A[mid] > i) high = mid - 1;
            else if (A[mid] < i) low = mid + 1;
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        A = new int[N];
        for(int i = 0; i<N; i++) A[i] = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] inputArr = new int[M];
        for(int i = 0; i< inputArr.length; i++) inputArr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(A);

        StringBuilder sb = new StringBuilder();

        for(int i : inputArr) sb.append(isExist(i)).append("\n");
        sb.setLength(sb.length()-1);
        System.out.println(sb);

    }
}
