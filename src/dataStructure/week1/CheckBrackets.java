package dataStructure.week1;

import java.util.Stack;

public class CheckBrackets {
	public static void main(String[] args) {
		CheckBrackets checkBrackets = new CheckBrackets();
		
		String input = "foo(bar[i);";
		
		Stack<Character> stk = new Stack<>();
		
		
		String result = checkBrackets.process(input, stk);
		System.out.println(result);
	}

	
	private String process(String input, Stack<Character> stk) {
		boolean flag = true;
		String message = "";
		for(int i=0;i<input.length();i++) {
			Character c = input.charAt(i);
			if(c == '(' || c=='[' || c=='{') {
				stk.push(c);
			} else {
				if(c==')' && stk.peek() == '(') {
					stk.pop();
				}
				else if(c==']' && stk.peek() == '[') {
					stk.pop();
				}
				else if(c=='}' && stk.peek() == '{') {
					stk.pop();
				} else if(c==')' || c=='}' || c==']' ) {
					flag = false;
					message = "unmatched closing bracket :"+(i+1) ;
					break;
				}
			}
		}
		if(flag == true && !stk.empty()) {
			// opening bracket found without closing bracket.
			flag = false;
			Character found = stk.peek();
			for( int i=0;i<input.length();i++ ) {
				char temp = input.charAt(i);
				if(found == temp) {
					message = "opening bracket at :"+(i+1);
				}
			}
			
		}
		
		if(flag == true) {
			message = "Success";
		} 
		return message;
	}
}
