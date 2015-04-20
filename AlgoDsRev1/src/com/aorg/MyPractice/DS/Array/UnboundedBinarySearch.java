package com.aorg.MyPractice.DS.Array;

public class UnboundedBinarySearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			int i=1;
			UnboundedBinarySearch unb = new UnboundedBinarySearch();
			while(unb.fucntion(i)<0){
				i = i*2;
			}
			int ind = unb.unboundedBinarySearch(i/2,i);
			System.out.println(ind);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	private int fucntion(int x){
		try{
			int val = (x*x)-(10*x)-20;
			return val;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	
	private int unboundedBinarySearch(int left,int right){
		try{
			int mid = (left+right)/2;
			if(fucntion(mid)>0&&fucntion(mid-1)<0){
				return mid;
			}
			if(fucntion(mid)>0&&fucntion(mid-1)>0){
				return unboundedBinarySearch(left,mid-1);
			}
			return unboundedBinarySearch(mid+1, right);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	
}
