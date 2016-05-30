package ds;

import java.util.EmptyStackException;
import java.util.Scanner;

public class MaximumElement {
	public static void main(String [] args){
		Scanner in = new Scanner(System.in);
        int numQueries = in.nextInt();
        
        int[] types = new int[numQueries];
        int[] operands = new int[numQueries];
        for (int i = 0; i < numQueries; i++) {
        	types[i] = in.nextInt();
        	//If type is 1 , read next int to
        	if(types[i] == 1){
        		operands[i] = in.nextInt();
        	}
        }
        
        MyStack tempStack = new MyStack(numQueries);
        for (int i = 0; i < types.length; i++) {
        	if(types[i] == 1){
        		tempStack.push(operands[i]);
        		continue;
        	}
        	else if (types[i] == 2) {
				tempStack.pop();
			}
        	else{
        		tempStack.printMax();
        	}
			
		}
	}
	
	private static class MyStack {
		int[] stack;
		int top;
		public MyStack(int size){
			stack = new int[size];
			top = -1;
		}
		
		public void push(int element){
			++top;
			if(top >= stack.length){
				throw new ArrayIndexOutOfBoundsException("can't insert at index, which does not exists.");
			}
			stack[top] = element;
		}
		
		public int pop(){
			if(top < 0 ){
				throw new EmptyStackException();
			}
			return stack[top--];
		}
		
		public void printMax(){
			if(top < 0){
				return;
			}
			int max = stack[0];
			for(int i = 0; i <= top; i++){
				if(max <= stack[i]){
					max = stack[i];
				}
			}
			System.out.println(max);
		}
	}
}
