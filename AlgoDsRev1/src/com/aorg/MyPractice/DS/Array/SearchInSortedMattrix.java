package com.aorg.MyPractice.DS.Array;

public class SearchInSortedMattrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			int[][] mat = {
							{10, 20, 30, 40},
		                    {15, 25, 35, 45},
		                    {27, 29, 37, 48},
		                    {32, 33, 39, 50},
						};
			int key = 29;
			int row = 4;
			int col = 4;
			boolean b = new SearchInSortedMattrix().isElementInMattrix(mat, row, col, key);
			if(b){
				System.out.println("HI...");
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	public boolean isElementInMattrix(int[][] mat,int row,int col,int key){
		try{
			int i = 0;
			int j = col-1;
			while(i < row && j >= 0){
				if(mat[i][j] == key){
					return true;
				}else if(key > mat[i][j]){
					i++;
				}else{
					j--;
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
}
