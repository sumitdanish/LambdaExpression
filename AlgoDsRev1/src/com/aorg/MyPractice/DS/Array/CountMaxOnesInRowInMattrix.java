package com.aorg.MyPractice.DS.Array;
/*
 *May 8, 2015
 *SUMMIT
 *6:17:56 PM
 *2015
 *
 */
public class CountMaxOnesInRowInMattrix {

	public static void main(String[] args) {
		try{
			int[] a = {0,0,0,1,1,1,1,1,1};
			int key = 1;
			int[][] mat = { {0,0,0,0,0,1,1},
							{0,0,0,1,1,1,1},
							{0,0,0,1,1,1,1},
							{0,0,1,1,1,1,1},
							{0,1,1,1,1,1,1}
						 };
			int row = 5;
			int col = 7;
			int rowIndex = new CountMaxOnesInRowInMattrix().rowNumber(mat, 5, 7);
			System.out.println(rowIndex);
//			int ind = new CountMaxOnesInRowInMattrix().binarySearch(a,0,a.length, key);
//			System.out.println(ind);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}
	
	public int rowNumber(int[][] mat,int row,int col){
		try{
			int sum;
			int maxSum = Integer.MIN_VALUE;
			int rowNo = 0;
			for(int i = 0;i<row;i++){
				int ind = binarySearch(mat[i],0,col,1);
				sum = col - ind;
				if(maxSum < sum){
					maxSum = sum;
					rowNo = i;
				}
			}
			return rowNo;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	public int binarySearch(int[] a,int left,int right,int key){
		try{
			int mid = (left+right)/2;
			if(mid-1 >=left && a[mid] == 1 && a[mid-1] < a[mid]){
				return mid;
			}
			if(mid+1 <= right && a[mid+1] == 1 && a[mid] < a[mid+1]){
				return mid+1;
			}
			if(mid-1 >= left && a[mid] == 1 && a[mid-1] == a[mid]){
				return binarySearch(a, left,mid-1, key);
			}
			if(mid+1 < right){
				return binarySearch(a,mid+1, right, key);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
}
