package ds;

import java.util.Scanner;

public class AndXorOr {

	 public AndXorOr(int size){
		 
	 }
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		AndXorOr solution = new AndXorOr(N);
		int result = (((m1 & m2) ^ (m1 | m2)) & (m1 ^ m2));
		
		System.out.println(result);
	}
	
	/**
	 * Helper Stack class with trivial operations
	 * 
	 * @author Mohit
	 */
	private class MyStack {
		int[] arr;
		int top;

		public MyStack(int size) {
			arr = new int[size];
			top = -1;
		}

		public void push(int element) {
			++top;
			if (top >= arr.length) {
				throw new ArrayIndexOutOfBoundsException("can't insert at index, which does not exists.");
			}
			arr[top] = element;
		}

		public int pop() {
			if (isEmpty()) {
				return -1;
			}
			int element = arr[top];
			arr[top--] = 0;
			return element;
		}

		public int peek() {
			if (isEmpty()) {
				return 1000000001;
			}
			return arr[top];
		}

		public boolean isEmpty() {
			return top < 0 ? true : false;
		}

		public void reverse() {
			MyStack tempStack = new MyStack(this.top + 1);
			while (!this.isEmpty()) {
				tempStack.push(this.pop());
			}
			this.arr = tempStack.arr;
			this.top = tempStack.top;
		}

		@Override
		public String toString() {
			StringBuilder sBuilder = new StringBuilder("");
			for (int i = 0; i <= top; i++) {
				sBuilder.append(arr[i]).append(" ");
			}
			return sBuilder.toString();
		}
	}
}
