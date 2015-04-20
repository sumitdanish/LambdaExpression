package com.aorg.MyPractice.DS.Array;

public class MinimumDistanceBetweenTwoNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			int[] a = {3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3};
			int x = 3;
			int y = 6;
			new MinimumDistanceBetweenTwoNumbers().minimumDistance(a, x, y);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	public void minimumDistance(int[] a,int x,int y){
		try{
			int minDis = Integer.MIN_VALUE;
			int pre = 0;
			int  i =0;
			for(i = 0;i<a.length;i++){
				if(a[i] == x || a[i] == y){
					pre = i;
					break;
				}
			}
			for(;i<a.length;i++){
				if(a[i] == x || a[i] == y){
					if(a[pre] != a[i] && i-pre > minDis){
						minDis = i-pre;
						pre = i;
					}else{
						pre = i;
					}
				}
			}
			System.out.println("Minimum Distance : "+minDis);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
