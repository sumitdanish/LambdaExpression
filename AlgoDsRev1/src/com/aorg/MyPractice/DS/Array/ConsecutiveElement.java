package com.aorg.MyPractice.DS.Array;

public class ConsecutiveElement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try{
			int[] a = {5, 2, 3, 1, 4};
			boolean b = new ConsecutiveElement().isConsecutive1(a);
			if(b){
				System.out.println("KJHKJH");
			}else{
				System.out.println("KJHDK");
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	private boolean isConsecutive1(int[] a){
		try{
			int min = getMin(a);
			int max = getMax(a);
			if(max - min + 1 == a.length){
				for(int i = 0;i<a.length;i++){
					if(a[i] < 0){
						return false;
					}
					a[a[i] - min] = - a[i] - min;
				}
				return true;
			}
			return false;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
	
	private boolean isConsecutive(int[] a){
		try{
			int min = getMin(a);
			int max = getMax(a);
			boolean[] vi = new boolean[a.length];
			if(max - min + 1 == a.length){
				for(int i = 0;i<a.length;i++){
					if(vi[a[i] - min] == true){
						return false;
					}
					vi[a[i] - min] = true;
				}
				return true;
			}
			return false;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
	
	private int getMax(int[] a){
		try{
			int max = Integer.MIN_VALUE;
			for(int i = 0;i<a.length;i++){
				if(max < a[i]){
					max = a[i];
				}
			}
			return max;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	private int getMin(int[] a){
		try{
			int min = Integer.MAX_VALUE;
			for(int i = 0;i<a.length;i++){
				if(min > a[i]){
					min = a[i];
				}
			}
			return min;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
}
