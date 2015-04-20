package com.aorg.MyPractice.DS.StringAlgo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Locale;
import java.util.Random;

public class GenrateDictionary {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			new GenrateDictionary().genrateWord();
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	public void genrateWord(){
		try{
			ArrayList<Integer> al = new ArrayList<Integer>();
			ArrayList<String> st = new ArrayList<String>();
			File file = new File("C:\\Users\\SU915198\\Desktop\\dictgen.docx");
			FileOutputStream f = new FileOutputStream(file);
			for(int j = 65 ; j <= 90 ; j++){
				al.add(new Integer(j));
			}
			for(int j = 97 ; j <= 122 ; j++){
				al.add(new Integer(j));
			}
			 StringBuilder sb = new StringBuilder();
			for(int i = 0;i < 6000;i++){
				 Collections.shuffle(al);
				 for(int l = 0 ; l<randomNumber() ; l++){
					 sb = sb.append(String.valueOf((char)(al.get(randomNumber())).intValue()).toUpperCase());
				 }
				 sb = sb.append(":");
				 for(int l = 0 ; l<randomNumber() ; l++){
					 sb = sb.append(String.valueOf((char)(al.get(randomNumber())).intValue()).toUpperCase());
				 }
				 sb.append("\n");
			}
			byte[] con = sb.toString().getBytes();
			f.write(con);
			f.flush();
			f.close();
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public int randomNumber(){
		try{
			Random r = new Random();
			int Low = 6;
			int High = 20;
			int R = r.nextInt(High-Low) + Low;
			return R;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	
	
}
