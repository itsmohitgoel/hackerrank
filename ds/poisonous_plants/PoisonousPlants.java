package ds;

import java.util.Scanner;

public class PoisonousPlants {
	MyStack stackOfPlants;
	int numOfPlants;

	public PoisonousPlants(int size) {
		stackOfPlants = new MyStack(size);
		numOfPlants = size;
	}

	private void pushPlant(int plant) {
		stackOfPlants.push(plant);
	}

	private void reverseOrder() {
		stackOfPlants.reverse();
	}

	public int calcNumOfSickenDays() {
		short minDays = -1;
		int oldNumOfPlants = 0;
		int newNumOfPlants = numOfPlants;
		boolean isEven = true;
		MyStack auxillaryStack = new MyStack(numOfPlants);
		while (oldNumOfPlants != newNumOfPlants) {
//			if(isEven){
//				while (!stackOfPlants.isEmpty()) {
//					int topValue = stackOfPlants.pop();
//					
//					if (topValue <= stackOfPlants.peek()) {
//						auxillaryStack.push(topValue);
//					}
//				}
//				isEven = false;
//			}else{
//				int leftItem = stackOfPlants.pop();
//				auxillaryStack.push(leftItem);
//				while(!stackOfPlants.isEmpty()){
//					int topValue = stackOfPlants.pop();
//					if (topValue <= leftItem) {
//						auxillaryStack.push(topValue);
//					}
//					leftItem = topValue;
//				}
//				isEven = true;
//			}
			
			
			
			while (!stackOfPlants.isEmpty()) {
				int topValue = stackOfPlants.pop();

				if (topValue <= stackOfPlants.peek()) {
					auxillaryStack.push(topValue);
				}
			}
			auxillaryStack.reverse();

			oldNumOfPlants = this.numOfPlants;
			
			//swap the stack references
			MyStack tempStack = this.stackOfPlants;
			this.stackOfPlants = auxillaryStack;
			auxillaryStack = tempStack;
			
			this.numOfPlants = stackOfPlants.top + 1;
			newNumOfPlants = this.numOfPlants;
			System.out.println(this);
			++minDays;
		}
		return minDays;
	}

	@Override
	public String toString() {
		return stackOfPlants.toString();
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		PoisonousPlants allPlants = new PoisonousPlants(N);

//		allPlants.pushPlant(1);
//		for (int i = N; i > 1; i--) {
//			allPlants.pushPlant(i);
//		}
		for (int i = 1; i <= N; i++) {
			allPlants.pushPlant(in.nextInt());
		}

		int result = allPlants.calcNumOfSickenDays();
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
