package com.aorg.MyPractice.DS.Array;

import java.util.Arrays;
import java.util.Random;
public class KthSmallest {

	/**
	 * @param args
	 */
	
	static int[] minHeap;
	static int size;
	static Random rand = new Random();
	public static void main(String[] args) {
		try{
			int[] array = {7, 10, 4, 3, 20, 15};
			KthSmallest kth = new KthSmallest(array.length,array);
			//int val = kth.kthSmallestElement(0,array.length,array,3);
			//System.out.println(val);
//			KthSmallest kth = new KthSmallest(array.length,array);
			kth.createHeap(minHeap);
			kth.getKthElement(3);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	public KthSmallest(int size,int[] array){
		try{
			KthSmallest.size = size;
			minHeap = new int[size];
			minHeap = Arrays.copyOfRange(array,0,array.length);
			createHeap(minHeap);
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
	
	private void getKthElement(int k){
		try{
			int temp = 0;
			for(int i=0;i<k;i++){
				temp = extract();
			}
			System.out.println(temp);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
	
	private void createHeap(int[] minHeap){
		try{
			int heapSize = size;
			int i = (heapSize-1)/2;
			while(i>0){
				minHepify(i);
				i--;
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
	private int extract(){
		try{
			int temp = minHeap[0];
			if(size>1){
				minHeap[0] = minHeap[size-1];
				size--;
				minHepify(0);
			}
			return temp;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	
	private void minHepify(int i){
		try{
			int lp = getLeft(i);
			int rp = getRight(i);
			int s = i;
			if(lp<size&&minHeap[lp]<minHeap[s]){
				s=lp;
			}
			if(rp<size&&minHeap[rp]<minHeap[s]){
				s=rp;
			}
			if(s!=i){
				int temp = minHeap[i];
				minHeap[i] = minHeap[s];
				minHeap[s]=temp;
				minHepify(s);
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	private int getLeft(int i){
		return 2*i;
	}
	private int getRight(int i){
		return 2*i+1;
	}
	
	
	/*By Using QuickSelect Method*/
	
	
	
	private int kthSmallestElement(int l,int r,int []a,int k){
		try{
			if(k>0&&k<=r-l+1){
				int ranIndex = getRandomIndexForPivot(l, r, a);
				if(ranIndex==k-1){
					return a[ranIndex];
				}
				if(ranIndex>k-1){
					return kthSmallestElement(l, ranIndex-1, a, k);
				}
				return kthSmallestElement(ranIndex+1, r, a, k-ranIndex+l-1);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	
	
	private int partioned(int[] a,int left,int right){
		try{
			int i = left;
			int temp = 0;
			int x = a[right];
			for(int j = left;j<right;j++){
				if(a[j]<=x){
					temp = a[j];
					a[j] = a[i];
					a[i] = temp;
					i++;
				}
			}
			temp = a[i] ;
			a[i] = a[right];
			a[right] = temp;
			
			return i;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	private int getRandomIndexForPivot(int l,int r,int[] a){
		try{
			int n = r-l+1;
			int index = rand.nextInt(n);
			int temp = a[index+1];
			a[index+1] = a[r];
			a[r] = temp;
			return partioned(a,l,r);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
}
