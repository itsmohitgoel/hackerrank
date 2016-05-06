import java.util.Scanner;

public class MergeSort {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        
        int[] arr = new int[count];
        for (int i = 0; i < count; i++) {
            arr[i] = in.nextInt();
        }
        if (count <= 1){
            return;
        }
        mergeSort(arr, 0, count-1);
        printArray(arr);
    }
    
    static void merge(int arr[], int first, int last){
    	int[] tempArray = new int[last - first + 1];

    	int mid = (first+last)/2;
        int i1 =0;
        int i2 = first;
        int i3 = mid+1;
        
        while(i2<=mid && i3<=last){
            if(arr[i2] > arr[i3]){
                tempArray[i1] = arr[i3];
                ++i1;
                ++i3;
            }else{
                tempArray[i1] = arr[i2];
                ++i1;
                ++i2;
            }
        }
       
        if(i2 > mid){
        	//copy rest of last half
        	while(i3 <= last){
        		tempArray[i1] = arr[i3];
        		++i1;
        		++i3;
        	}
        }else if(i3 > last){
        	//Copy rest of first half
        	while(i2 <= mid){
        		tempArray[i1] = arr[i2];
        		++i1;
        		++i2;
        	}
        }
        
        //copy temp array back to original
        int refIndex = first;
        for(int i = 0; i < tempArray.length; i++){
        	arr[refIndex++] = tempArray[i];
        }
    }
    
    /** Perform MergeSort recursively
     * @param arr	array to be sorted
     * @param first	beginning index
     * @param last ending index
     */
    static void mergeSort(int arr[], int first, int last){
        if(first < last){
            int mid = (first+last)/2;
            mergeSort(arr, first, mid);
            mergeSort(arr, mid+1, last);
            
            merge(arr,first,last);
        }
    }

    static void printArray(int[] ar) {
        for (int val: ar) {
            System.out.print(val + " ");
        }
        System.out.println("");
    }
}
