package com.aorg.MyPractice.DS.Array;

public class ElementInSortedAndRoatedArray {

	/**
	 * @param args
	 * we can't take the condition directly
	 * 			i.e a[mid] > a[mid+1] && a[mid] < a[mid-1] we should avoid this condition
	 * 			because two condition can be possible
	 * 			either a[mid] > a[mid+1] or a[mid] < a[mid-1]
	 */
	public static void main(String[] args) {
		try{
			int[] a = {4,5,6,6,1,1,2,2,3};
			int ele = new ElementInSortedAndRoatedArray().binasySearch(a,0,a.length-1);
			System.out.println(ele);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	private int binasySearch(int[] a,int low,int high){
		try{
			if(low == high && a[low] > a[high]){
				return a[high];
			}
			int mid = (low+high)/2;
			if(mid + 1 <= high && a[mid] > a[mid+1]){
				return a[mid+1];
			}
			if(mid-1 >= low && a[mid] < a[mid-1]){
				return a[mid];
			}
			if(mid-1 >= low && mid+1 <= high && ((a[mid]==a[mid-1]) || a[mid] == a[mid+1])){
				return getMaxMin(binasySearch(a, low,mid-1),binasySearch(a,mid+1, high));
			}
			if(a[mid] < a[high]){
				if(mid+1 <= high){
					return binasySearch(a,mid+1, high);
				}
			}
			if(a[mid] > a[low]){
				if(mid-1 >= low){
					return binasySearch(a, low,mid-1);
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	private int getMaxMin(int a,int b){
		try{
			return a > b ? b : a;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
}
