package com.aorg.MyPractice.DS.Array;

public class MaxSumOfArrayNotAdjacent {

	//3 2 7 10
	public static void main(String[] args){
		try{
			int[] a = {3,2,7,10};
			new MaxSumOfArrayNotAdjacent().getMaxSum(a);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public void getMaxSum(int[] a){
		try{
			int sum1 = a[0];
			int sum2 = 0;
			int sum3 = 0;
			for(int i = 1; i< a.length ; i++){
				sum3 = getMax(sum1,sum2);
				sum1 = sum2+a[i];
				sum2 = sum3;
			}
			System.out.println(getMax(sum1,sum2));
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public int getMax(int a,int b){
		try{
			return a > b ? a: b;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
}
