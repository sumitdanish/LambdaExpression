package com.aorg.MyPractice.DS.Array;

public class PrintMattrixInSortedOrder {

	/**
	 * @param args
	 */
	Mattrix[] minHeap;
	int heapSize;
	public static void main(String[] args) {
		try{
			int[][] mat={   {10, 20, 30, 40},
                    		{15, 25, 35, 45},
                    		{27, 29, 37, 48},
                    		{32, 33, 39, 50},
                  		};
			int n=4;
			PrintMattrixInSortedOrder p = new PrintMattrixInSortedOrder(mat,n);
			p.printMat(mat, n);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	
	public PrintMattrixInSortedOrder(int[][] mat,int n){
		try{
			Mattrix[] mattrix = new Mattrix[n];
			for(int i=0;i<n;i++){
				Mattrix m1 = new Mattrix(i,1,mat[i][0]);
				mattrix[i] = m1;
			}
			createMinHeap(mattrix,n);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void printMat(int[][] mat,int n){
		try{
			for(int i=0;i<n*n;i++){
				Mattrix m2 = extract();
				System.out.print(m2.getELement()+",");
				if(m2.getI()<n&&m2.getJ()<n){
					m2.setElement(mat[m2.getI()][m2.getJ()]);
					m2.setJ(m2.getJ()+1);
				}else{
					m2.setElement(Integer.MAX_VALUE);
				}
				replace(m2);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
	public void createMinHeap(Mattrix[] minHeap,int heapSize){
		try{
			this.minHeap = minHeap;
			this.heapSize = heapSize;
			int i = (heapSize-1)/2;
			while(i>=0){
				minHeapify(i);
				i--;
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
	
	public void minHeapify(int i){
		try{
			int left = getLeft(i);
			int right = getRight(i);
			int s = i;
			if(left<this.heapSize&&this.minHeap [left].getELement()<this.minHeap [s].getELement()){
				s=left;
			}
			if(right<this.heapSize&&this.minHeap [right].getELement()<this.minHeap [s].getELement()){
				s=right;
			}
			if(s!=i){
				Mattrix temp = this.minHeap [s];
				this.minHeap [s] = this.minHeap [i];
				this.minHeap [i]=temp;
				minHeapify(s);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public int getLeft(int i){
		try{
			return (2*i+1);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	public int getRight(int i){
		try{
			return (2*i+2);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	public Mattrix extract(){
		try{
			Mattrix m= this.minHeap [0];
			return m;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	public void replace(Mattrix m){
		try{
			this.minHeap [0] = m;
			minHeapify(0);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}


class Mattrix
{
	public int i;
	public int j;
	public int element;
	public Mattrix(int i,int j,int element){
		this.element = element;
		this.i=i;
		this.j=j;
	}
	public Mattrix(int i,int element){
		this.i = i;
		this.element = element;
	}
	public void setI(int i){
		this.i=i;
	}
	public void setJ(int j){
		this.j=j;
	}
	public void setElement(int element){
		this.element = element;
	}
	
	public int getELement(){
		return element;
	}
	public int getI(){
		return i;
	}
	public int getJ(){
		return j;
	}
}