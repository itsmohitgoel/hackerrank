import java.util.Scanner;

public class FindDigits {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int[] numbers = new int[t];
        
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            numbers[a0] = n;
        }
        
        for (int number : numbers) {
			System.out.println(numOfDigits(number));
		}
    }
    
    private static int numOfDigits(int n){
    	int num = n;
    	int digit = 0;
    	int count = 0;
    	
    	while (num != 0) {
    		digit = num % 10;
    		num /= 10;
    		
    		if (digit != 0 && n % digit == 0) {
				++count;
			}
			
		}
    	return count;
    }
}
