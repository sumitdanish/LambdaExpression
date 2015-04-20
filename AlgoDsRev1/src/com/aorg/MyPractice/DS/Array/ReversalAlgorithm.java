package com.aorg.MyPractice.DS.Array;

public class ReversalAlgorithm {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1, 2, 3, 4, 5, 6, 7};
		new ReversalAlgorithm().rotate(a,2,a.length-1);
	}

	
	public void rotate(int[] a,int d,int len){
		try{
			reverse(a, 0,d);
			reverse(a, d+1,len);
			reverse(a, 0,len);
			for(int a1 : a){
				System.out.print(a1+",");
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
	public void reverse(int[] a,int d,int n){
		try{
			int end = n;
			int be = d;
			while(be < end){
				int temp = a[end];
				a[end] = a[be];
				a[be] = temp;
				be++;
				end--;
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
}
