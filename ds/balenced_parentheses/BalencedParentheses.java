package ds;

import java.util.EmptyStackException;
import java.util.Scanner;

public class BalencedParentheses {

	public static void main(String [] args){
		Scanner in = new Scanner(System.in);
        int numOfTestcase = in.nextInt();
        
        String[] inputs = new String[numOfTestcase];
        for(int i = 0; i < inputs.length; i++){
        	inputs[i] = in.next();
        }
        for (String stmt : inputs) {
			MyStack openingBraces = new MyStack(stmt.length());
			String result = "YES";
			
			for(int j = 0 ; j < stmt.length(); ++j){
				char ch = stmt.charAt(j);
				if(ch == '(' || ch == '{' || ch == '['){
					openingBraces.push(ch);
				}else if (ch == ')' || ch == '}' || ch == ']') {
					char tempChar = openingBraces.pop();
					if(!((tempChar == '(' && ch == ')') ||
							(tempChar == '{' && ch == '}') ||
							(tempChar == '[' && ch == ']'))){
						result = "NO";
						break;
					}
				}
			}
			if(!openingBraces.isEmpty()){
				result = "NO";
			}
			System.out.println(result);
		}
	}
}

class MyStack {
	char[] stack;
	int top;
	public MyStack(int size){
		stack = new char[size];
		top = -1;
	}
	
	public void push(char element){
		++top;
		if(top >= stack.length){
			throw new ArrayIndexOutOfBoundsException("can't insert at index, which does not exists.");
		}
		stack[top] = element;
	}
	
	public char pop(){
		if(top < 0 ){
			return '!';
		}
		return stack[top--];
	}
	
	public boolean isEmpty(){
		return top<0? true: false;
	}
}
