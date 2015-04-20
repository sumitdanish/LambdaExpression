package com.aorg.MyPractice.DS.Array;

public class MinimumDistanceBetweenTwoNumbers1 {

	/**
	 * @param args
	 * Input: arr[] = {3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3}, x = 3, y = 6
	   Output: Minimum distance between 3 and 6 is 4.
	 */
	public static void main(String[] args) {
		try{
			int[] a = {3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3};
			int x = 3;int y = 6;
			new MinimumDistanceBetweenTwoNumbers1().minimumDiatance(a, x, y);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	public void minimumDiatance(int[] a,int x,int y){
		try{
			int pre = 0;
			int i = 0;
			int minLen = Integer.MAX_VALUE;
			for(i = 0;i<a.length &&(a[i] == x || a[i] == y);i++){
				pre = i;break;
			}
			for(;i<a.length;i++){
				if( a[i] != a[pre] && (a[i] == x || a[i] == y)  && ((i - pre) < minLen)){
					minLen = Math.abs(i - pre);
				}
			}
			System.out.println(minLen);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
}
