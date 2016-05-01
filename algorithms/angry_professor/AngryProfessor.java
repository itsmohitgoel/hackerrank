import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class AngryProfessor {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        boolean[] resultArray = new boolean[t];
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int k = in.nextInt();
            int a[] = new int[n];
            for(int a_i=0; a_i < n; a_i++){
                a[a_i] = in.nextInt();
            }
            
            resultArray[a0] = shouldCancel(n, k, a);
        }
        for (boolean b : resultArray) {
        	if(b){
        		System.out.println("YES");
        	}
        	else{
        		System.out.println("NO");
        	}
		}
    }
    
    public static boolean shouldCancel(int n, int k, int [] entryTimes){
    	int onTimeStudents = 0;
    	for (int i : entryTimes) {
			if(i <= 0){
				++onTimeStudents;
			}
		}
    	
    	boolean result = (onTimeStudents <k)? true : false;
    	return result;
    }
}