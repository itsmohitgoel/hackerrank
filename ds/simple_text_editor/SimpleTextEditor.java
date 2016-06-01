package ds;

import java.util.Scanner;

public class SimpleTextEditor {
	StringBuilder textBuilder;
	MyStack strStates;

	public SimpleTextEditor(int size) {
		textBuilder = new StringBuilder("");
		strStates = new MyStack(size);
		strStates.push(textBuilder.toString());
	}

	private void append(String value) {
		textBuilder.append(value);
		strStates.push(textBuilder.toString());
	}

	private void erase(int k) {
		textBuilder.delete(textBuilder.length() - k, textBuilder.length());
		strStates.push(textBuilder.toString());
	}

	private void get(int k) {
		System.out.println(textBuilder.charAt(--k));
	}

	private void undo() {
		strStates.pop();
		textBuilder = new StringBuilder(strStates.peek());
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		SimpleTextEditor editor = new SimpleTextEditor(N);
		for (int i = 1; i <= N; i++) {
			int operation = in.nextInt();
			switch (operation) {
			case 1:
					String str = in.next();
					editor.append(str);
				break;

			case 2:
				int k = in.nextInt();
				editor.erase(k);
				break;
			case 3:
				int l = in.nextInt();
				try {
					editor.get(l);
					
				} catch (Exception e) {
					// TODO: handle exception
					System.err.println("i is " + i);
					System.exit(0);
				}
				break;
			case 4:
				editor.undo();
				break;
			default:
				break;
			}
		}
		
	}

	/**
	 * Helper Stack class with trivial operations
	 * 
	 * @author Mohit
	 *
	 */
	private static class MyStack {
		String[] arr;
		int top;

		public MyStack(int size) {
			arr = new String[size];
			top = -1;
		}

		public void push(String element) {
			++top;
			if (top >= arr.length) {
				throw new ArrayIndexOutOfBoundsException("can't insert at index, which does not exists.");
			}
			arr[top] = element;
		}

		public String pop() {
			if (isEmpty()) {
				return "";
			}
			String str = arr[top];
			arr[top--] = null;
			return str;
		}

		public String peek() {
			if (isEmpty()) {
				return "";
			}
			return arr[top];
		}

		public boolean isEmpty() {
			return top < 0 ? true : false;
		}
	}
}
