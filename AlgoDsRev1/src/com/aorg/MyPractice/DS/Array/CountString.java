package com.aorg.MyPractice.DS.Array;

public class CountString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try{
			int n = 5;
			CountString c = new CountString();
			int count = c.countString(n);
			System.out.println(count);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	private int countString(int n){
		try{
			int[] a = new int[n];
			int[] b = new int[n];
			a[0] = b[0] = 1;
			for(int i1=1;i1<n;i1++){
				a[i1] = a[i1-1]+b[i1-1];
				b[i1] = a[i1-1];
			}
			return (a[n-1]+b[n-1]);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	
}
