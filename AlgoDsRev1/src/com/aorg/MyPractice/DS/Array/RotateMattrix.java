package com.aorg.MyPractice.DS.Array;

public class RotateMattrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			int[][] mat = {
							{1,2,3,4}, 
							{5,6,7,8}, 
							{9,10,11,12},
						  };
			new RotateMattrix().transposeOfMattrix(mat, 3,4);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	public void transposeOfMattrix(int[][] mat,int row,int col){
		try{
			int[][] mat1 = new int[col][row];
			int j1 = 0;
			int k = col-1;
			int co = 0;
			for(int i = 0; i<row; i++){
				for(int j = 0;j<col;j++){
					mat1[j][i] = mat[i][j];
				}
			}
			System.out.println("Transpose of the mattrix");
			System.out.println();
			for(int i = 0;i<col;i++){
				for(int j = 0;j<row;j++){
					System.out.print(mat1[i][j]+",");
				}
				System.out.println();
			}
			System.out.println("Rotaion to left side of the mattrix\n");
			while(j1 <= k){
				for(int i = 0;i<row;i++){
					int temp = mat1[k][i];
					mat1[k][i] = mat1[j1][i];
					mat1[j1][i] = temp;
				}
				j1++;k--;
			}
			for(int i = 0;i<col;i++){
				for(int j = 0;j<row;j++){
					System.out.print(mat1[i][j]+",");
				}
				System.out.println();
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
}
