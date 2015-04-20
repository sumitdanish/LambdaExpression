package com.aorg.MyPractice.DS.Array;

public class FloodFillAlgorithm {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			FloodFillAlgorithm fd = new FloodFillAlgorithm();
			int[][] mat = {
							{1, 1, 1, 1, 1, 1, 1, 1},
		                    {1, 1, 1, 1, 1, 1, 0, 0},
		                    {1, 0, 0, 1, 1, 0, 1, 1},
		                    {1, 2, 2, 2, 2, 0, 1, 0},
		                    {1, 1, 1, 2, 2, 0, 1, 0},
		                    {1, 1, 1, 2, 2, 2, 2, 0},
		                    {1, 1, 1, 1, 1, 2, 1, 1},
		                    {1, 1, 1, 1, 1, 2, 2, 1},
                   		  };
			int xCor = 4;
			int yCor = 4;
			int preColor = 2;
			int newColor = 3;
			int row = 8;
			int col = 8;
			fd.floodFillAlgo(mat, xCor, yCor, row-1, col-1, newColor, preColor);
			for(int i=0;i<row;i++){
				for(int j=0;j<col;j++){
					System.out.print(mat[i][j]+",");
				}
				System.out.println();
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	private void floodFillAlgo(int[][] mat,int xCor,int yCor,int row,int col,int newColor,int preColor){
		try{
			if(xCor<0||xCor>col||yCor<0||yCor>row){
				return;
			}
			if(mat[xCor][yCor]!=preColor){
				return;
			}
			mat[xCor][yCor] = newColor;
			floodFillAlgo(mat, xCor+1, yCor, row, col, newColor, preColor);
			floodFillAlgo(mat, xCor-1, yCor, row, col, newColor, preColor);
			floodFillAlgo(mat, xCor, yCor+1, row, col, newColor, preColor);
			floodFillAlgo(mat, xCor, yCor-1, row, col, newColor, preColor);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
