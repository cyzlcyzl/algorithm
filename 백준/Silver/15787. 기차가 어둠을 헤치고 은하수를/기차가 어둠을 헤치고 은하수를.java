import java.io.*;
import java.util.*;

public class Main{
    
    static int[][] train;
    
    static void firstOrder(int i, int x){
        if(train[i][x] != 0) return;
        train[i][x] = 1;
    }
    
    static void secondOrder(int i, int x){
        if(train[i][x] == 0) return;
        train[i][x] = 0;
    }
    
    static void thirdOrder(int i){
        int tmp = train[i][0];
        train[i][0] = 0;
        
        for(int k = 1; k<20; k++){
            int now = tmp;
            tmp = train[i][k];
            train[i][k] = now;
        }
    }
    
    static void forthOrder(int i){
        int tmp = train[i][19];
        train[i][19] = 0;
        
        for(int k = 18; k>=0; k--){
            int now = tmp;
            tmp = train[i][k];
            train[i][k] = now;
        }
    }
    
    static int checkPassenger(int[][] train){
        Set<String> memo = new HashSet<>();
        
        for(int[] row : train){
            StringBuilder passenger = new StringBuilder();
            for(int num : row) passenger.append(num);
            memo.add(passenger.toString());
        } 
        
        return memo.size();
    }
    

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		train = new int[N][20];
		
		for(int k = 0; k<M; k++){
		    String[] command = br.readLine().split(" ");
		    if(command[0].equals("1")){
		        int i = Integer.parseInt(command[1])-1;
		        int x = Integer.parseInt(command[2])-1;
		        firstOrder(i, x);
		    }
		    else if(command[0].equals("2")){
		        int i = Integer.parseInt(command[1])-1;
		        int x = Integer.parseInt(command[2])-1;
		        secondOrder(i, x);
		    }
		    else if(command[0].equals("3")){
		        int i = Integer.parseInt(command[1])-1;
		        thirdOrder(i);
		    }
		    else if(command[0].equals("4")){
		        int i = Integer.parseInt(command[1])-1;
		        forthOrder(i);
		    }
		}
		
		int answer = checkPassenger(train);
		System.out.println(answer);
	}
}
