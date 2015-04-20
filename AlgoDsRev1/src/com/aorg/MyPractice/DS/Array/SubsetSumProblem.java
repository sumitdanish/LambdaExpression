package com.aorg.MyPractice.DS.Array;

public class SubsetSumProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			int[] a = {3, 34, 4, 12, 5, 2};
			int sum = 9;
			boolean b = new SubsetSumProblem().isSubsetSum(a, sum,a.length-1);
			if(b){
				System.out.println("Yes");
			}else{
				System.out.println("No..");
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	private boolean isSubsetSum1(int[] a,int sum,int n){
		try{
//			boolean[][] su = new boolean[][];
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
	
	
	
	private boolean isSubsetSum(int[] a,int sum,int n){
		try{
			
			if(sum==0||n==0){
				return true;
			}
			if(sum!=0&&n==0){
				return false;
			}
			if(a[n-1] > sum){
				return isSubsetSum(a, sum, n-1);
			}
			return isSubsetSum(a, sum, n-1)||isSubsetSum(a, sum-a[n-1], n-1);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
	
	
}
