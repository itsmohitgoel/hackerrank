import java.util.Scanner;

public class SherlockAndTheBeast {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        String[] stringArray = new String[t];
        
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            stringArray[a0] = calculateKey(n);
        }
        in.close();
        
        for (String s : stringArray) {
			System.out.println(s);
		}
        
    }
    
    private static String calculateKey(int n) {
    	int number = n;
    	if (n == 5 || n == 10) {
			number = 0;
		}else{
			while((number % 3) != 0){
				number = number - 5;
			}
			if(number <= 0 && n!= 5){
				return "-1";
			}
		}
    	int fiveCount = number;
    	int threeCount = (n - number);
    	
    	StringBuilder sb = new StringBuilder();
    	for (int i = 0; i < fiveCount; i++) {
			sb.append("5");
		}
    	for (int i = 0; i < threeCount; i++) {
    		sb.append("3");
    	}
	
    	return sb.toString();
	}
}
