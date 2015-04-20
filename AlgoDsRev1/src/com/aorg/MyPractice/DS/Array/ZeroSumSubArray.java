package com.aorg.MyPractice.DS.Array;

import java.util.HashMap;

public class ZeroSumSubArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			int[] a = {4, 2, -3, 1, 6};
			boolean b = new ZeroSumSubArray().isSubArraySum(a);
			if(b){
				System.out.println("Zero sum sub array is present");
			}else{
				System.out.println("Zero sum sub array is not there");
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	
	private boolean isSubArraySum(int[] a){
		try{
			HashMap<Integer,Integer>  map = new HashMap<Integer, Integer>();
			int sum=0;
			for(int i=0;i<a.length;i++){
				sum+=a[i];
				if(sum==0||a[i]==0||map.containsKey(sum)){
					return true;
				}
				map.put(sum,i);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
	
	
}
