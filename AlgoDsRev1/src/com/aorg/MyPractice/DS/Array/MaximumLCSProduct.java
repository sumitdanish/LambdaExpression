package com.aorg.MyPractice.DS.Array;

public class MaximumLCSProduct {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			int[] a ={1, 5, 10, 8, 9};
			for(int a1 : new MaximumLCSProduct().maxProd(a)){
				System.out.print(a1+",");
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	private int[] maxProd(int[] a){
		try{
			int left = 0;
			int right = 0;
			int[] sub = new int[3];
			int maxP = Integer.MIN_VALUE;
			for(int i=1;i<a.length-1;i++){
				for(int j=0;j<a.length;j++){
					if(a[j] < a[i] && left<a[j]){
						left = a[j];
					}
				}
				for(int k=i+1;k<a.length;k++){
					if(a[k]>a[i]&&right<a[k]){
						right = a[k];
					}
				}
				int prod = right*left*a[i];
				if(maxP<prod&&(right-a[i]>1&&a[i]-left>1&&right-left>1)){
					maxP = prod;
					sub = new int[]{left,a[i],right};
				}
			}
			return sub;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
}
