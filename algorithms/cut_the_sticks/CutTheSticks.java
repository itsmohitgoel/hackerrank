import java.util.Scanner;

public class CutTheSticks {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int arr_i=0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        printSticks(arr);
        in.close();
    }
    
    public static void printSticks(int[] sticks){
    	int[] copyOfSticks = new int[sticks.length];
    	for (int i = 0; i < sticks.length; i++) {
			copyOfSticks[i] = sticks[i];
		}
    	
    	int remainingSticks = sticks.length;
    	
    	while(remainingSticks > 0){
    		int shortestStick = findMinimum(copyOfSticks);
    		int countRemovedSticks = countValues(copyOfSticks, shortestStick);
    		System.out.println(remainingSticks);
    		
    		for (int i = 0; i < copyOfSticks.length; i++) {
				if(copyOfSticks[i] == 0){
					continue;
				}
				
				if(copyOfSticks[i] == shortestStick){
					++countRemovedSticks;
					--remainingSticks;
				}
				
				copyOfSticks[i] -= shortestStick;
			}
    	}
    	
    }
    
    public static int findMinimum(int[] arr){
    	if(arr.length == 0){
    		throw new ArrayIndexOutOfBoundsException("Length of array should be atleast one!");
    	}
    	int min = -1;
    	for (int i : arr) {
			if(i > 0){
				min = i;
				break;
			}
		}
    	if(min == -1){
    		return min;
    	}
    	
    	int countZeros = 0;
    	for (int i = 0; i < arr.length; i++) {
    		if(arr[i] < 0){
    			throw new IllegalArgumentException("Height of stick should be atleast one");
    		}
    		if(arr[i] == 0){
    			++countZeros;
    			continue;
    		}
			if(arr[i] < min){
				min = arr[i];
			}
		}
    	if(countZeros == arr.length){
    		return -1;
    	}
    	
    	return min;
    }
    
    public static int countValues(int[] arr, int k){
    	int countValues = 0;
    	for (int value : arr) {
			if(value != 0 && value > k){
				++countValues;
			}
		}
    	return countValues;
    }
}
