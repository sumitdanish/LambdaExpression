package com.aorg.MyPractice.DS.Array;

public class ArrayRotation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			int[] a = {1, 2, 3, 4, 5, 6, 7};
			new ArrayRotation().rotation(a,2);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	private void rotation(int[] a,int d){
		try{
			for(int i = 0;i< d; i++){
				arrayLeftRotation(a);
			}
			for(int a1 : a){
				System.out.print(a1+",");
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
	private void arrayLeftRotation(int[] a){
		try{
			int n = a.length-1;
			int temp = a[0];
			int i = 0;
			while(i < n - 1){
				a[i] = a[i+1];
				i++;
			}
			a[i] = temp;
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
}
