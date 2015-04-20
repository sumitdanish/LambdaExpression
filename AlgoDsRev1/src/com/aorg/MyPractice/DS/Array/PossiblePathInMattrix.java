package com.aorg.MyPractice.DS.Array;

public class PossiblePathInMattrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			 int[][] mat = { 
					 			{1, 2, 3}, 
					 			{4, 5, 6}
					 	  };
			int m=2;
			int n=3;
			int path = new PossiblePathInMattrix().path1(m, n);
			new PossiblePathInMattrix().printPath(mat,0,0,m,n,0,new String());
			System.out.println(path);
		}catch(Exception ex){
			ex.printStackTrace();
			
		}

	}

	
	private int path(int m,int n){
		try{
			if(m==1||n==1){
				return 1;
			}
			return (path(m-1, n)+path(m, n-1));
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	
	private int path1(int m,int n){
		try{
			int[][] path = new int[m+1][n+1];
			for(int i=0;i<m;i++){
				path[i][0] = 1;
			}
			for(int j=0;j<n;j++){
				path[0][j] = 1;
			}
			for(int i=1;i<m;i++){
				for(int j=1;j<m;j++){
					path[i][j] = path[i-1][j]+path[i][j-1];
				}
			}
			return path[m-1][n-1];
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	private void printPath(int[][] mat,int fromRow,int fromCol,int row,int col,int pi,String path){
		try{
			if(fromRow==row-1){
				for(int i=fromCol;i<col;i++){
					path+=String.valueOf(mat[fromRow][i]);
				}
				System.out.println(path);
				return;
			}
			if(fromCol==col-1){
				for(int i=fromRow;i<row;i++){
					path+=String.valueOf(mat[i][fromCol]);
				}
				System.out.println(path);
				return;
			}
			path+=String.valueOf(mat[fromRow][fromCol]);
			printPath(mat, fromRow+1, fromCol, row, col, pi+1, path);
			printPath(mat, fromRow, fromCol+1, row, col, pi+1, path);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
