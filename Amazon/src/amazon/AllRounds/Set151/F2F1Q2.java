package amazon.AllRounds.Set151;

public class F2F1Q2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			int row = 6;
			new F2F1Q2().printPascal(row);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}
	
	private void printPascal(int row){
		try{
			int r = 0;
			int[][] a = new int[row][row];
			for(r = 0;r<row;r++){
				for(int k = 1;k<row-r;k++){
					System.out.print(" ");
				}
				for(int j = 0;j<=r; j++){
					if(r == row || j == 0){
						a[r][j] = 1;
					}else{
						a[r][j] = a[r-1][j - 1]+a[r-1][j];
					}
					System.out.print(a[r][j]+" ");
				}
				System.out.println();
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
}
