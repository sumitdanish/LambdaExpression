package com.aorg.MyPractice.DS.Array;

public class SmallestSubarray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			SmallestSubarray ss = new SmallestSubarray();
			int[] a = {1, 4, 45, 6, 0, 19};
			int key = 51;
			int x = ss.countSmallestSubArray1(a, key);
			System.out.println(x);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	/*TC O(N2)*/
	
	private int countSmallestSubArray(int[] a,int key){
		try{
			int count = 0;
			int st =0 ;
			int minLen = Integer.MAX_VALUE;
			for(int i=0;i<a.length;i++){
				count = a[i];
				for(int j=i+1;j<a.length-1;j++){
					count+=a[j];
					if(count>key&&minLen>(j-i+1)){
						minLen = j-i+1;
					}
				}
			}
			return minLen;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	
	private int countSmallestSubArray1(int[] a,int key){
		try{
			int start = 0;
			int countSum=0;
			int minLen = Integer.MAX_VALUE;
			for(int i=0;i<a.length;i++){
				while(countSum<=key&&i<a.length){
					countSum+=a[i];
					i++;
				}
				while(countSum>key&&start<a.length){
					if(minLen>(i-start)){
						minLen = i-start;
					}
					countSum-=a[start++];
				}
			}
			return minLen;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	
}
