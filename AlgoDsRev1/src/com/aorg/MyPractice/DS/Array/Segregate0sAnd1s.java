package com.aorg.MyPractice.DS.Array;

public class Segregate0sAnd1s {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			int[] a = {0, 1, 0, 1, 0, 0, 1, 1, 1, 0};
			new Segregate0sAnd1s().segregate(a);
			for(int a1 : a){
				System.out.print(a1+",");
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	
	public void segregate(int[] a){
		try{
			int i = 0;int j = a.length-1;
			while(i < j){
				while(a[i] == 0 && i < j){
					i++;
				}
				while(a[j] == 1 && i < j){
					j--;
				}
				if(i<j){
					a[i] = 0;
					a[j] = 1;
					i++;j--;
				}
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public void swap(int a,int b){
		try{
			int temp = a;
			a = b;
			b = temp;
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
