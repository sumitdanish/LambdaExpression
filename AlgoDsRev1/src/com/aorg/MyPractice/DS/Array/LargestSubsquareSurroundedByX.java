package com.aorg.MyPractice.DS.Array;

public class LargestSubsquareSurroundedByX {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			LargestSubsquareSurroundedByX sequence = new LargestSubsquareSurroundedByX();
			int row = 5;
			int col = 6;
			char[][] mat =  {   {'X', 'O', 'X', 'X', 'X', 'X'},
                    			{'X', 'O', 'X', 'X', 'O', 'X'},
			                    {'X', 'X', 'X', 'O', 'O', 'X'},
			                    {'X', 'X', 'X', 'X', 'X', 'X'},
			                    {'X', 'X', 'X', 'O', 'X', 'O'},
                            }; 
			sequence.getMaxSubSquireForX(mat, row, col);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	private int getMaxSubSquireForX(char[][] mat,int row,int col){
		try{
			int[][] hori = new int[row][col];
			int[][] ver = new int[row][col];
			hori[0][0]=ver[0][0] = (mat[0][0]=='X'?1:0);
			for(int r=0;r<row;r++){
				for(int c=0;c<col;c++){
					if(mat[r][c]=='O'){
						hori[r][c]=ver[r][c]=0;
					}else{
						hori[r][c] = 1+hori[r][(c==0?1:c)-1];
						ver[r][c] = 1+ver[(r==0?1:r)-1][c];
					}
				}
			}
			
			for(int r=0;r<row;r++){
				for(int c=0;c<col;c++){
					System.out.print(hori[r][c]+",");
				}
				System.out.println();
			}
			System.out.println("\n");
			for(int r=0;r<row;r++){
				for(int c=0;c<col;c++){
					System.out.print(ver[r][c]+",");
				}
				System.out.println();
			}
			int max=1;
			int small=0;
			for(int r=row-1;r>=0;r--){
				for(int c=col-1;c>=0;c--){
					small = getMin(hori[r][c],ver[r][c]);
					while(small>max){
						if(hori[r-small+1][c]>=small&&ver[r][c-small+1]>=small){
							max=small;
						}
						small--;
					}
				}
			}
			System.out.println("\n Small > "+max);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	private int getMin(int a,int b){
		try{
			return a>b?b:a;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
}
