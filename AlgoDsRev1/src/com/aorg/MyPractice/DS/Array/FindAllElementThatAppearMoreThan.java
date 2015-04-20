package com.aorg.MyPractice.DS.Array;

public class FindAllElementThatAppearMoreThan {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			int[] a = {4, 5, 6, 7, 8, 4, 4};
			int k = 3;
			new FindAllElementThatAppearMoreThan().find(a,k);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	private void find(int[] a,int k){
		try{
			
			Find[] f = new Find[k-1];
			for(int p = 0;p < k-1;p++){
				f[p] = new Find();
			}
			int ac = 0 ;
			for(int i=0;i<k-1;i++){
				f[i].count = 0;
			}
			for(int i=0;i<a.length;i++){
				int l = 0;
				for(l = 0;l<k-1;l++){
					if(f[l].element == a[i]){
						f[l].count++;
						break;
					}
				}
				if(l==k-1){
					int j = 0;
					for(j=0;j<k-1;j++){
						if(f[j].count == 0){
							f[j].element = a[i];
							f[j].count = 1;
							break;
						}
					}
					if(j==k-1){
						for(int o = 0;o<k-1;o++){
							f[o].count = -1;
						}
					}
				}
			}
			for(int i=0;i<k-1;i++){
				ac = 0;
				for(int j=0;j<a.length;j++){
					if(f[i].element == a[j]){
						ac++;
					}
				}
				if(ac>(a.length-1)/k){
					System.out.println(ac+" > "+f[i].element);
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
}
class Find
{
	public int count;
	public int element;
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getElement() {
		return element;
	}
	public void setElement(int element) {
		this.element = element;
	}
	
}