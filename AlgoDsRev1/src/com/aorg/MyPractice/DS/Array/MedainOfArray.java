package com.aorg.MyPractice.DS.Array;

import java.util.Arrays;

public class MedainOfArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			int[] a1 = {1, 2, 3, 6};
			int[] a2 = {4, 6, 8, 10};
			int me = new MedainOfArray().getMedain1(a1, a2,a1.length);
			System.out.println(me);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	private void getMedain(int[] a1,int[] a2){
		try{
			int m1 = 0;
			int m2 = 0;
			int i = 0;
			int j = 0;
			while(i < a1.length && j < a2.length){
				if(i == a1.length -1){
					m1 = m2;
					m2 = a2[0];
					break;
				}else if(j == a2.length-1){
					m1 = m2;
					m2 = a1[0];
					break;
				}else if(a1[i] < a2[j]){
					m1 = m2;
					m2 = a1[i];
					i++;
				}else{
					m1 = m2;
					m2 = a2[j];
					j++;
				}
			}
			System.out.println(m1+" > "+m2);
			System.out.println((m1+m2)/2);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
	private int getMedain1(int[] a1,int[] a2,int size){
		try{
			if(size < 0){
				return -1;
			}
			if(size == 2){
				int medain1 = getMax(a1[0], a2[0]);
				int medain2 = getMax(a1[1], a2[1]);
				return (medain1+medain2)/2;
			}
			int m1 = medain(a1);
			int m2 = medain(a2);
			if(m1 == m2){
				return m1;
			}
			if(m2 > m1){
				int[] a11 = null;
				if(size % 2 ==0){
					a11 = Arrays.copyOfRange(a1,size/2-1,a1.length);
					return getMedain1(a11, a2, size-size/2+1);
				}else{
					a11 = Arrays.copyOfRange(a1,size/2,a1.length);
					return getMedain1(a11, a2, size-size/2);
				}
			}
			if(m2 < m1){
				int[] a21 = null;
				if(size % 2 ==0){
					a21 = Arrays.copyOfRange(a2,size/2-1,a2.length);
					return getMedain1(a21, a1, size-size/2+1);
				}else{
					a21 = Arrays.copyOfRange(a2,size/2,a2.length);
					return getMedain1(a21, a1, size-size/2);
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	
	private int getMax(int a1,int a2){
		try{
			return a1 > a2 ? a1:a2;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	private int medain(int[] a){
		try{
			int n = a.length-1;
			if((n) % 2 ==0){
				return (a[n/2]+a[n/2-1])/2;
			}else{
				return a[n/2];
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
}
