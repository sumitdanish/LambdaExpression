package com.aorg.MyPractice.DS.Array;

public class Count0s {

	
	public static void main(String[] args){
		try{
			int[] a ={1, 1, 1, 0, 0, 0};
			int n = new Count0s().binarySearch(a,0,a.length);
			System.out.println((a.length-n)-1);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	private int binarySearch(int[] a,int left,int right){
		try{
			int mid = (left+right)/2;
			if((a[mid]==1&&a[mid+1]==0)){
				return mid;
			}
			if(a[mid]==1&&a[mid+1]==1){
				return binarySearch(a, mid+1, right);
			}
			return binarySearch(a, left,mid-1);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	
}
