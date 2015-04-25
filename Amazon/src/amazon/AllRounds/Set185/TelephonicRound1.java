package amazon.AllRounds.Set185;

import java.util.Stack;

public class TelephonicRound1 {

	public static void main(String[] args) {
		try{
			int[] a = {18, 17, 4, 3, 5, 2};
			new TelephonicRound1().nextGreaterElementStack(a);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	public void nextGreaterElementStack(int[] a){
		try{
			Stack<Integer>  st = new Stack<Integer>();
			int next = -1;
			int element = 0;
			st.add(a[0]);
			for(int i = 1;i<a.length;i++){
				next = a[i];
				if(!st.isEmpty()){
					element = st.pop();
					while(element < next){
						System.out.println(element+" > "+next);
						if(st.isEmpty()){
							break;
						}
						element = st.pop();
					}
					if(element > next){
						st.add(element);
					}
				}
				st.add(next);
			}
			while(!st.isEmpty()){
				System.out.println(st.pop()+" > "+-1);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
	public void nextGreaterElement(int[] a){
		try{
			int minElement = -1;
			for(int i = a.length-1;i>=0;i--){
				int temp = a[i];
				a[i] = minElement;
				if(temp > minElement){
					minElement = temp;
				}
			}
			for(int i = 0;i<a.length;i++){
				System.out.print(a[i]+",");
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
}
