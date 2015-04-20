package com.aorg.MyPractice.DS.Array;

public class CountingSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			int[] a = {170, 45, 75, 90, 802, 24, 2, 66};
			new CountingSort().radixSort(a,a.length);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}
	
	private void countSort(int[] a,int n,int exp){
		try{
			int[] count = new int[n+1];
			int[] op = new int[n+1];
			int mod = 10;
			for(int i=0;i<a.length;i++){
				count[(a[i]/exp)%mod]++;
			}
			for(int i=1;i<n;i++){
				count[i]+=count[i-1];
			}
			for(int i=0;i<a.length;i++){
				op[count[(a[i]/exp)%mod]-1] = a[i];
				count[(a[i]/exp)%mod]--;
			}
			for(int i=0;i<a.length;i++){
				a[i] = op[i];
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	
	
	private void radixSort(int[] a,int exp){
		try{
			int max = getMax(a);
			for(exp=1;(max/exp)>0;exp*=10){
				countSort(a, a.length, exp);
			}
			print(a);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	private void print(int[] a){
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+",");
		}
	}
	
	
	
	private int getMax(int[] a){
		try{
			int max=Integer.MIN_VALUE;
			for(int i=0;i<a.length;i++){
				if(max<a[i]){
					max=a[i];
				}
			}
			return max;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	
}
