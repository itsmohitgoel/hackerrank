package ds;

import java.util.Scanner;

public class LargestRectangle {
	public static void main(String [] args){
		Scanner in = new Scanner(System.in);
        int numBuildings = in.nextInt();
        
        int[] heightArray = new int[numBuildings];
        for (int i = 0; i < numBuildings; i++) {
        	heightArray[i] = in.nextInt();
        }
        
        System.out.println(findMaxRectangle(heightArray));
	}
	
	private static int findMaxRectangle(int[] heights){
		if(heights == null || heights.length == 0){
			return 0;
		}
		MyStack stack = new MyStack(heights.length);
		//Initialize Max Area
		int area = 0;
		int maxArea = 0;
		int i = 0;
		
		//run through all buildings of given heights
		while(i < heights.length){
			//If current building is higher than the stack's top index's building,
			// push its height's index on top of stack, ELSE
			if(stack.isEmpty() || heights[i] >= heights[stack.peek()]){
				stack.push(i);
				i++;
			}
			else{
				//If curr_buildings is lower than the stack's peek index's building,
				// calc area of rectangle, with stack op as the smallest building,
				int topIndex = stack.pop();
				if(stack.isEmpty()){
					area = heights[topIndex] * i;
				}
				else{
					area = heights[topIndex] * (i - stack.peek() -1);
				}
				maxArea = Math.max(maxArea, area);
			}
		}
		
		while(!stack.isEmpty()){
			int topIndex = stack.pop();
			if(stack.isEmpty()){
				area = heights[topIndex] * i ;
			}
			else{
				area = heights[topIndex] * (i - stack.peek() -1 );
			}
			maxArea = Math.max(maxArea, area);
		}
		return maxArea;
	}
	
	private static class MyStack {
		int[] arr;
		int top;
		public MyStack(int size){
			arr = new int[size];
			top = -1;
		}
		
		public void push(int element){
			++top;
			if(top >= arr.length){
				throw new ArrayIndexOutOfBoundsException("can't insert at index, which does not exists.");
			}
			arr[top] = element;
		}
		
		public int pop(){
			if(isEmpty()){
				return -1;
			}
			return arr[top--];
		}
		
		public int peek(){
			if(isEmpty()){
				return -1;
			}
			return arr[top];
		}
		public boolean isEmpty(){
			return top < 0 ? true: false;
		}
	}
}



