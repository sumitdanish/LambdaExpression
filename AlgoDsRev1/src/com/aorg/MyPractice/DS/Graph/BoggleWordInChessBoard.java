package com.aorg.MyPractice.DS.Graph;

import java.util.HashMap;

public class BoggleWordInChessBoard {

	public static void main(String[] args) {
		try{
			BoggleWordInChessBoard bo = new BoggleWordInChessBoard();
			char[][] mat = {{'G','I','Z'},
                    		{'U','E','K'},
                    		{'Q','S','A'}};
			int row = 3;
			int col = 3;
			HashMap<String,String> map = new HashMap();
			map.put("GEEKS","GEEKS");
			map.put("QUIZ","QUIZ");
			bo.boogleWord(mat, row, col,map);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	public void boogleWord(char[][] mat,int row,int col,HashMap<String,String> dict){
		try{
			String str = new String();
			boolean[][] v = new boolean[row][col];
			for(int i = 0;i<row;i++){
				for(int j = 0;j<col;j++){
					dfsBoogleWord(i, j, v, mat, str, dict, row, col);
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void dfsBoogleWord(int i,int j,boolean[][] v,char[][] mat,String str,HashMap<String, String> dict,int row,int col){
		try{
			str = str+mat[i][j];
			v[i][j] = true;
			if(dict.containsKey(str.toString())){
				System.out.println(str.toString());
			}else{
				for(int x = i-1;x<=i+1&&x<row;x++){
					for(int y = j-1;y<=j+1&&y<col;y++){
						if(y>=0 && x>=0 && x<row && y<col && !v[x][y]){
							dfsBoogleWord(x,y, v, mat, str, dict, row, col);
						}
					}
				}
			}
			str = null;
			v[i][j] = false;
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
