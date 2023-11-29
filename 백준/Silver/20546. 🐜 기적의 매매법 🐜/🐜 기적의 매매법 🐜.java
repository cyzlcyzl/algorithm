import java.io.*;
import java.util.*;

public class Main{
    
    static int[] stocks;
    
    static int getJun(int start){
        int stock = 0;
        int money = start;
        
        for(int price : stocks){
            if(money < price) continue;
            stock += money / price;
            money %= price;
            if(money == 0) break;
        }
        
        return calAsset(stock, money);
    }
    
    static int getSeong(int start){
        int stock = 0;
        int money = start;
        int up = 0;
        int down = 0;
        
        for(int i = 1; i<14; i++){
            if(stocks[i]>stocks[i-1]){
                up++;
                down = 0;
            }
            
            else if(stocks[i]<stocks[i-1]){
                down++;
                up = 0;
            }
            
            if(up != 3 && down != 3) continue;
            if(stocks[i] > money) continue;
            
            if(up==3){
                money += stocks[i] * stock;
                stock = 0;
            }
            else if(down == 3){
                stock += money / stocks[i];
                money %= stocks[i];
            }
        }
        return calAsset(stock, money);
    }
    
    static int calAsset(int stock, int money){
        return stock * stocks[13] + money;
    }
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int money = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		stocks = new int[14];
		for(int i = 0; i<14; i++){
		    stocks[i] = Integer.parseInt(st.nextToken());
		}
		
		int Jun = getJun(money);
		int Seong = getSeong(money);
		
		if(Jun > Seong) System.out.println("BNP");
		else if (Jun < Seong) System.out.println("TIMING");
		else System.out.println("SAMESAME");
	}
}
