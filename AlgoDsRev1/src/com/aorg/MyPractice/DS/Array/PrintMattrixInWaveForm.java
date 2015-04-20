package com.aorg.MyPractice.DS.Array;

public class PrintMattrixInWaveForm {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			int[][] mat =  { {0,1,2,3,4},
					         {5,6,7,8,9},
					         {10,11,12,13,14},
					        {15,16,17,18,19}
						};
			new PrintMattrixInWaveForm().printMattrix(mat,4,5);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}
	
	
	private void printMattrix(int[][] mat,int row,int col){
		try{
			boolean flag = false;
			int j = 0;
			for(int i=0;i<col;i++){
				if(!flag){
					j=0;
					while(j<row){
						System.out.print(mat[j][i]+",");
						j++;
					}
					flag = !flag;
				}else{
					j--;
					while(j>=0){
						System.out.print(mat[j][i]+",");
						j--;
					}
					flag = !flag;
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
}
