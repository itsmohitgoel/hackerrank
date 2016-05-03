import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ChocolateFeast {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int[] chocolatesArray = new int[t];
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int c = in.nextInt();
            int m = in.nextInt();
            
            chocolatesArray[a0] = calculateChocolates(n, c, m);
        }
        for (int count : chocolatesArray) {
			System.out.println(count);
		}
    }
    
    public static int calculateChocolates(int n, int c,  int m){
    	int totalChocolates = n / c;
    	int num = totalChocolates;
    	int rem = 0;
    	int quotient = 0;
    	
    	while ((num  + rem ) >= m) {
    		quotient = num;
    		if(rem == 0){
    			rem = quotient % m;
    			num = (num )/ m;
    		}else{
    			num = (num + rem) / m;
    			rem = (quotient + rem) % m;
    		}
			totalChocolates += num;
		}
    	
    	return totalChocolates;
    }
}
