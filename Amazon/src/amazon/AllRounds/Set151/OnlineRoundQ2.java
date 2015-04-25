package amazon.AllRounds.Set151;

public class OnlineRoundQ2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			int row = 3;
			int col = 4;
			int[][] mat = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
			new OnlineRoundQ2().rotateMattrix(mat, row, col);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}
	
	public void rotateMattrix(int[][] mat,int row,int col){
		try{
			 int[][] mat1 = new int[col][row];
			 int i1 = 0;
			 int k1 =  col-1; 
			 for(int i = 0;i<row;i++){
				 for(int j = 0;j<col;j++){
					 mat1[j][i] = mat[i][j];
				 }
			 }
			 for(int i = 0;i<row;i++){
				 for(int j = 0;j<col;j++){
					 System.out.print(mat[i][j]+",");
				 }
				 System.out.println();
			 }
			 System.out.println();
			 for(int i = 0;i<col;i++){
				 for(int j = 0;j<row;j++){
					 System.out.print(mat1[i][j]+",");
				 }
				  System.out.println();
			 }
			 System.out.println();
			 while(i1 <= k1){
				 for(int l = 0;l < row;l++){
					 int temp = mat1[i1][l];
					 mat1[i1][l] = mat1[k1][l];
					 mat1[k1][l] = temp;
				 }
				 i1++;
				 k1--;
			 }
			 System.out.println("After rotation > ");
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
