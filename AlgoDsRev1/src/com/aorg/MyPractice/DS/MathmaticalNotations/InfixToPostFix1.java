package com.aorg.MyPractice.DS.MathmaticalNotations;

import java.util.HashMap;
import java.util.Stack;

public class InfixToPostFix1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			String st = "A*(B+C–D/E)/F" ;
			
			new InfixToPostFix1().infixToPostFix(st.toCharArray());
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	private void infixToPostFix(char[] exp){
		try{
			Stack<Character> st = new Stack<Character>(); 
			for(int i=0;i<exp.length;i++){
				if(exp[i] >= 'A' && exp[i] <= 'Z'){
					
						System.out.print(exp[i]);
						
				}else if(exp[i] == '('){
					st.push(exp[i]);
				}else if(exp[i] == ')'){
					while(!st.isEmpty() && st.peek()!='('){
						System.out.print(st.pop()); 
					}
					char c = !st.isEmpty()?st.pop():' ';
				}else{
					while(!st.isEmpty() && preference(exp[i]) <= preference(st.peek())){
						System.out.print(st.pop());
					}
					st.push(exp[i]);
				}
			}
			while(!st.isEmpty()){
				System.out.print(st.pop());
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
	private int preference(char ch){
		try{
			if(ch == '+' || ch == '-'){
				return 1;
			}
			if(ch == '*' || ch == '/'){
				return 2;
			}
			if(ch == '^'){
				return 3;
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
}
