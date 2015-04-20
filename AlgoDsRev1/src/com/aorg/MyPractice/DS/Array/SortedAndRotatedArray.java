package com.aorg.MyPractice.DS.Array;

public class SortedAndRotatedArray {

	/**
	 * @param args
	 * Given a sorted and rotated array, find if there is a pair with a given sum
	 */
	public static void main(String[] args) {
		
		try{
			int[] a = {11, 15, 6, 8, 9, 10};
			new SortedAndRotatedArray().getSumOfPair(a, 16);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	private void getSumOfPair(int[] a,int sum){
		try{
			int pivot = getPivot(a,0,a.length-1);
			int l = pivot;
			int r = l-1;
			//int x = sum - a[pivot];
			while(l!=r){
				if(a[r]+a[l] == sum){
					System.out.println("Pair of the sum : "+a[l]+" > "+a[r]);
					break;
				}else if(a[r]+a[l] < sum){
					l++;
				}else{
					r += a.length-1-1;
				}
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
	
	private int getPivot(int[] a,int l,int r){
		try{
			int mid = (l+r)/2;
			if(l == r){
				return l;
			}
			if(mid > l && a[mid] < a[mid-1]){
				return mid;
			}
			if(mid+1 < r && a[mid+1] < a[mid]){
				return mid+1;
			}
			if(mid+1 < r && a[mid] > a[l]){
				return getPivot(a, mid+1, r);
			}
			if(mid-1 > l && a[mid] < a[r]){
				return getPivot(a,l,mid-1);
			}
			return -1;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	
}
