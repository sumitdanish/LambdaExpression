package com.aorg.MyPractice.DS.Array;

public class SearchInARowWiseAndColumnWiseSorted2DArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			int[][] mat = new int[][] { {10, 20, 30, 40}, 
					                    {15, 25, 35, 45},
					                    {27, 29, 37, 48},
					                    {32, 33, 39, 50}
					                  };
			int key = 50;
			//new SearchInARowWiseAndColumnWiseSorted2DArray().search(mat,4,4, key);
			new SearchInARowWiseAndColumnWiseSorted2DArray().search(mat,0,4,0,4, key);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	/*TC O(N)*/
	private void search(int[][] mat,int row,int col,int key){
		try{
			int i=0;
			int j = row-1;
			while(i<col&&j>=0){
				if(mat[i][j]==key){
					System.out.println("Element found at : "+i+" > "+j);
					return;
				}else if(mat[i][j]<key){
					i++;
				}else{
					j--;
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/*TC O(NLOG(N))*/
	
	private void search(int[][] mat,int fromRow,int toRow,int fromCol,int toCol,int key){
		try{
			int midRow = (fromRow+toRow)/2;
			int midCol = (fromCol+toCol)/2;
			if(mat[midRow][midCol]==key){
				System.out.println("ELement found at ; "+midRow+","+midCol);
				return;
			}else{
				if(midCol!=fromCol&&midRow!=toRow){
					search(mat, fromRow,midRow, midCol, toCol, key);
				}
				if(fromCol+1==toCol&&fromRow==toRow){
					if(key==mat[fromCol][toRow]){
						System.out.println("ELement found at ; "+midRow+","+midCol);
						return;
					}
				}
				if(key>mat[midRow][midCol]){
					if(midRow+1<toRow){
						search(mat,midRow+1, toRow, fromCol, toCol, key);
					}
				}
				if(key<mat[midRow][midCol]){
					if(midCol-1>fromCol){
						search(mat, fromRow, toRow,midCol-1, toCol, key);
					}
				}
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
}
