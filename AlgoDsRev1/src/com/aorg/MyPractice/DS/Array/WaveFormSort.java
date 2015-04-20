package com.aorg.MyPractice.DS.Array;

public class WaveFormSort {

	/**
	 * @param args
	 * 		{ 		 {'X', 'O', 'X', 'X', 'X', 'X'},
                     {'X', 'O', 'X', 'X', 'O', 'X'},
                     {'X', 'X', 'X', 'O', 'O', 'X'},
                     {'X', 'X', 'X', 'X', 'X', 'X'},
                     {'X', 'X', 'X', 'O', 'X', 'O'},
              };
	 */
	static int[] a = {10, 5, 6, 3, 2, 20, 100, 80};
	static int[] temp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			WaveFormSort w = new WaveFormSort();
			temp = new int[a.length];
			w.mergeSort(0,a.length-1);
			w.waveSort();
			for(int a1:a){
				System.out.print(a1+",");
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	public WaveFormSort(){
		try{
			//temp = new int[size];
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	private void waveSort(){
		try{
			for(int i=0;i<a.length-1;i+=2){
				swap(i,i+1);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
	private void swap(int i,int j){
		try{
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
	
	private void quickSort(int l,int r){
		try{
			int p = a[(l+r)/2];
			int i=l;
			int j=r;
			while(i<j){
				while(a[i]<p){
					i++;
				}
				while(a[j]>p){
					j--;
				}
				if(i<=j){
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
					i++;
					j--;
				}
				if(l<j){
					quickSort(l,j);
				}
				if(i<r){
					quickSort(i,r);
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	private void mergeSort(int l,int r){
		try{
			if(l<r){
				int m = (l+r)/2;
				mergeSort(l,m);
				mergeSort(m+1, r);
				merge(l, m, r);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
	private void merge(int l,int m,int r){
		try{
			for(int i=l;i<=r;i++){
				temp[i] = a[i];
			}
			int left = l;
			int mid = m+1;
			int index=left;
			while(left<=m&&mid<=r){
				if(temp[left]<temp[mid]){
					a[index] = temp[left];
					left++;
				}
				if(temp[left]>temp[mid]){
					a[index]=temp[mid];
					mid++;
				}
				index++;
			}
			while(left<=m){
				a[index] = temp[left];
				left++;
				index++;
			}
			while(mid<=r){
				a[index] = temp[mid];
				mid++;
				index++;
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
	
}
