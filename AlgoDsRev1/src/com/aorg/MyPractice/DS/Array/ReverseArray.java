package com.aorg.MyPractice.DS.Array;

public class ReverseArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			int[] a = {1, 2, 3, 4, 5, 6};
			new ReverseArray().reverse(a,0,a.length-1);
			for(int a1 : a){
				System.out.print(a1+",");
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	private int[] reverseArray(int[] a){
		try{
			
			int s = 0;
			int e = a.length-1;
			while(s < e){
				int temp = a[s];
				a[s] = a[e];
				a[e] = temp;
				s++;e--;
			}
			return a;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	private void reverse(int[] a,int s,int e){
		if(s >= e){
			return;
		}
		int temp = a[s];
		a[s] = a[e];
		a[e] = temp;
		reverse(a, s+1,e-1);
	}
}
