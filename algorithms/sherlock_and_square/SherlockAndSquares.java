import java.util.Scanner;

public class SherlockAndSquares {

    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	int t = in.nextInt();
    	int[] counts = new int[t];
    	
    	for (int a0 = 0; a0 < t; a0++) {
			int a = in.nextInt();
			int b = in.nextInt();
			
			counts[a0] = findPerfectSquares(a, b);
		}
    	
    	for (int count : counts) {
			System.out.println(count);
		}
    }
    
    private static int findPerfectSquares(int a , int b){
    	
    	if(a == b){
    		if(isPerfectSquare(a)){
    			return 1;
    		}
    		return 0;
    	}
    	
    	int low = (int)Math.floor(Math.sqrt(a));
    	int high = (int)Math.ceil(Math.sqrt(b));
    	int count = 0;
    	
    	for (int i = low; i <= high; i++) {
			int squareTerm = i * i;
			if(squareTerm>= a && squareTerm <= b){
				++count;
			}
		}
//    	if((low % 1) == 0){ //check perfect Square
//    		++count;
//    	}
//    	
//    	if(a != b && (high % 1) == 0){ //check perfect Square
//    		++count;
//    	}
//    	
//    	a = (int)low;
//    	b = (int)high;
//    	
//    	int diff = b - a -1;
//    	if(diff >0){
//    		count += (b - a -1 );
//    	}
    	
    	return count;
    }
    
    private static boolean isPerfectSquare(double n){
    	if(((Math.sqrt(n)) % 1) == 0){
    		return true;
    	}
    	return false;
    }
}