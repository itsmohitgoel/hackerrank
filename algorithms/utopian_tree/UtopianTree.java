import java.util.Scanner;

public class UtopianTree {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int[] cycleArray = new int[t];
        
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            
            cycleArray[a0] = n;
        }
        
        double startTime = System.nanoTime();
        for (int cycle : cycleArray) {
			System.out.println(calculateHeight(cycle));
		}
        double endTime = System.nanoTime();
        
        System.out.printf("Time Elapsed : %f", ((endTime - startTime) / 1000000000));
    }
    
    private static int calculateHeight(int numCycle){
    	int height = 1;
    	if(numCycle == 0){
    		return height;
    	}
    	
    	for (int i = 1; i <= numCycle; i++) {
			if(i%2 != 0){// If it is Spring Season
				height *= 2;
			}else{	// If it is Summer Season
				++height;
			}
		}
    	
    	return height;
    }
}

