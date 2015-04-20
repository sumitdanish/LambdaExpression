package com.aorg.MyPractice.DS.Array;

public class SearchInAllMostSortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			SearchInAllMostSortedArray se = new SearchInAllMostSortedArray();
			int[] a = {10, 3, 40, 20, 50, 80, 70};
			int key = 800;
			int ind = se.binarySearch(a, key,0,a.length);
			System.out.println(ind);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	private int binarySearch(int[] a,int key,int l,int r){
		try{
			int mid = (l+r)/2;
			if(a[mid]==key){
				return mid;
			}
			if(mid-1>l&&a[mid-1]==key){
				return mid-1;
			}
			if(mid+1<r&&a[mid+1]==key){
				return mid+1;
			}
			if(mid-2>0&&a[mid]>key){
				return binarySearch(a, key,l,mid-2);
			}else if(mid+2<r){
				return binarySearch(a, key, mid+2,r);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	
}
