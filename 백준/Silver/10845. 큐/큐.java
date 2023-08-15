import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {
    static int last;
    static Queue<Integer> que = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();

    static void pop(){
        if(!que.isEmpty()) sb.append(que.poll()).append("\n");
        else sb.append(-1).append("\n");
    }
    static void size(){
        sb.append(que.size()).append("\n");
    }
    static void empty(){
        if(que.isEmpty()) sb.append(1).append("\n");
        else sb.append(0).append("\n");
    }
    static void front(){
        if(!que.isEmpty()) sb.append(que.peek()).append("\n");
        else sb.append(-1).append("\n");
    }
    static void back(){
        if(!que.isEmpty()) sb.append(last).append("\n");
        else sb.append(-1).append("\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i<N; i++){
            String[] comm = br.readLine().split(" ");
            String pComm = comm[0];
            if(comm.length==2){
                // push
                last = Integer.parseInt(comm[1]);
                que.offer(last);
            }
            else{
                if(pComm.equals("pop")) pop();
                else if (pComm.equals("size")) size();
                else if (pComm.equals("empty")) empty();
                else if (pComm.equals("front")) front();
                else if (pComm.equals("back")) back();
            }
        }
        br.close();

        if(sb.length()>1) sb.setLength(sb.length()-1);
        System.out.println(sb);
    }
}