import java.io.*;
import java.util.*;


public class Main {
    static Deque<Integer> deque = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();

    static void pop_front(){
        if(!deque.isEmpty()) sb.append(deque.pollFirst()).append("\n");
        else sb.append(-1).append("\n");
    }
    static void pop_back(){
        if(!deque.isEmpty()) sb.append(deque.pollLast()).append("\n");
        else sb.append(-1).append("\n");
    }
    static void size(){
        sb.append(deque.size()).append("\n");
    }
    static void empty(){
        if(deque.isEmpty()) sb.append(1).append("\n");
        else sb.append(0).append("\n");
    }
    static void front(){
        if(!deque.isEmpty()) sb.append(deque.peekFirst()).append("\n");
        else sb.append(-1).append("\n");
    }
    static void back(){
        if(!deque.isEmpty()) sb.append(deque.peekLast()).append("\n");
        else sb.append(-1).append("\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i<N; i++){
            String[] comm = br.readLine().split(" ");
            if(comm.length==2){
                int push = Integer.parseInt(comm[1]);
                if(comm[0].equals("push_front")) deque.offerFirst(push);
                else if(comm[0].equals("push_back")) deque.offerLast(push);
            }else{
                if(comm[0].equals("pop_front")) pop_front();
                else if(comm[0].equals("pop_back")) pop_back();
                else if(comm[0].equals("size")) size();
                else if(comm[0].equals("empty")) empty();
                else if(comm[0].equals("front")) front();
                else if(comm[0].equals("back")) back();
            }
        }
        br.close();

        if(sb.length()>1) sb.setLength(sb.length()-1);
        System.out.println(sb);

    }
}