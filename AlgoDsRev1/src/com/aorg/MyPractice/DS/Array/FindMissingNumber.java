package com.aorg.MyPractice.DS.Array;

public class FindMissingNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			FindMissingNumber fi = new FindMissingNumber();
			int[] a = {2, 4, 8, 10, 12, 14};
			int diff = (a[a.length-1]-a[0])/a.length;
			int missingNumber = fi.findMissingBinary(a,0,a.length, diff);//find(a, diff);
			System.out.println(missingNumber);
		}catch(Exception ex){
			ex.printStackTrace();
			
		}

	}

	
	
	private int find(int[] a,int diff){
		try{
			for(int i=0;i<a.length;i++){
				if(a[i+1]-a[i]!=diff){
					return (a[i+1]-a[i]+diff);
				}
			}
			return -1;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	private int findMissingBinary(int[] a,int l,int r,int diff){
		try{
			int mid=(l+r)/2;
			if(a[mid+1]-a[mid]!=diff){
				return (a[mid+1]-a[mid]+diff);
			}
			if(mid>0&&a[mid]-a[mid-1]!=diff){
				return (a[mid-1]+diff);
			}
			if(mid+1<r&&a[mid]==(a[0]+mid*diff)){
				return findMissingBinary(a, mid+1, r, diff);
			}
			return findMissingBinary(a, l,mid-1, diff);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
}
