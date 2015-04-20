package com.aorg.MyPractice.DS.Array;

public class FindTheMinimumElement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			int[] a = {5, 6, 0,1,1,2, 2,2,3, 3, 4};
			int minEl = new FindTheMinimumElement().getMinimumElement(a,0,a.length-1);
			System.out.println(minEl);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	
	private int getMinimumElement(int[] a,int left,int right){
		try{
			if(a[left]==a[right]){
				return a[left];
			}
			int mid = (left+right)/2;
			if(right>mid&&a[mid]>a[mid+1]){
				return a[mid+1];
			}
			if(left<mid-1&&a[mid-1]>a[mid]){
				return a[mid];
			}
			if(mid-1>left&&((a[right]>a[mid])||(a[mid]==a[right]))){
				return getMinimumElement(a, left,mid-1);
			}else if(mid+1<right&&((a[left]<a[mid])||(a[left]==a[mid])))
			return getMinimumElement(a,mid+1, right);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	
}
