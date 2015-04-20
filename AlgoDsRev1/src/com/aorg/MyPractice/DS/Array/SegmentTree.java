package com.aorg.MyPractice.DS.Array;

public class SegmentTree {

	/**
	 * @param args
	 */
	static int[] st;
	public static void main(String[] args) {
		try{
			int[] a = {1, 3, 5, 7, 9, 11};
			int maxSize = (2*a.length)-1;
			int c = (int) Math.ceil((Math.log(maxSize)));
			maxSize = (int) (2*Math.pow(c,2)); 
			SegmentTree se = new SegmentTree(maxSize);
			st = se.construct(a,0,a.length-1);
			int sum = se.getSum(st,1,3,st.length);
			System.out.println(sum);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	public SegmentTree(int maxSize){
		try{
			st = new int[maxSize];
		}catch(Exception ex){
			ex.printStackTrace();
			
		}
	}
	
	
	
	private void updateUtil(int[] st,int ss,int se,int i,int index,int newVal){
		try{
			if(i<ss||i>se){
				return;
			}
			st[index] = newVal;
			if(ss!=se){
				int mid = getMinIndex(ss, se);
				updateUtil(st, ss,mid-1, i, 2*index+1, newVal);
				updateUtil(st,mid+1, se, i, 2*index+2, newVal);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	private void update(int[] a,int i,int newVal){
		try{
			if(i<0||i>a.length-1){
				return;
			}
			int diff = newVal-a[i];
			a[i] = diff;
			updateUtil(st,0,a.length, i,0, newVal);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
	private int getMinIndex(int ss,int se){
		try{
			return (ss+se)/2;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	
	private int getSumUtil(int[] st,int ss,int se,int qs,int qe,int index) {
		try{
			if(index<st.length&&qs<=ss&&qe>=se){
				return st[index];
			}
			if(qs>se||qe<ss){
				return -1;
			}
			int mid = getMinIndex(ss, se);
			return getSumUtil(st, ss,mid, qs, qe, (2*index)+1)+getSumUtil(st,mid+1, se, qs, qe, (2*index)+2);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	private int getSum(int[] a,int qs,int qe,int len){
		try{
			if(qs<0||qs>qe||qe>len){
				System.out.println("Invalid Input");
				return -1;
			}
			return getSumUtil(a,0,len-1, qs, qe,0);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	
	private int constructTree(int[] a,int ss,int se,int[] st,int si){
		try{
			if(ss==se){
				st[si] = a[ss];
				return a[ss];
			}
			int mid = getMinIndex(ss, se);
			st[si] = constructTree(a, ss,mid, st,2*si+1)+constructTree(a,mid+1, se, st,2*si+2);
			return st[si];
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	private int[] construct(int[] a,int ss,int se){
		try{
			int MAX_SIZE = 2*se-1;
			int[] st1 = new int[MAX_SIZE];
			constructTree(a,ss,se,st,0);
			return st1;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
}
