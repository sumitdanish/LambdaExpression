package com.aorg.MyPractice.DS.Array;

public class MaxDiffWithMaxIndexDiff {

	public static void main(String[] args){
		try{
			int[] a = {34, 8, 10, 3, 2, 80, 30, 33, 1};
			new MaxDiffWithMaxIndexDiff().maxDiffWithMaxDiffInIndex(a);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void maxDiffWithMaxDiffInIndex(int[] a){
		try{
			int maxElement = a[0];
			int maxDiffSoFar = 0;
			int maxDiff = 0;
			boolean flag = true;
			int j = 0;
			for(int i = 0;i<a.length ; i++){
				maxDiff =a[j] - a[i];
				if(flag){
					flag = !flag;
					j = i;
				}
				if(maxDiffSoFar < maxDiff){
					maxDiffSoFar = maxDiff;
				}
				
				
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
}
