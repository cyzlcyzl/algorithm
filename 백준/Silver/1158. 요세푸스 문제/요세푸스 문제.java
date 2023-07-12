import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        br.close();

        List<Integer> list = new ArrayList<>();
        for(int i = 1; i<=N; i++) list.add(i);

        StringBuilder sb = new StringBuilder("<");
        int start = K - 1;
        while(true){
            int remove = list.remove(start);
            sb.append(remove).append(", ");
            if(list.isEmpty()) break;
            start += K - 1;
            while(start >= list.size()){
                start -= list.size();
            }
        }
        sb.setLength(sb.length()-2);
        sb.append(">");
        System.out.println(sb);
    }

}

