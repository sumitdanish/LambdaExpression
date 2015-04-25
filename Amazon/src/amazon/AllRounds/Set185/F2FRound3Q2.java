package amazon.AllRounds.Set185;
import java.util.*;
public class F2FRound3Q2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			String str = "leetcode";
			HashSet<String> dict = new HashSet<String>();
			dict.add("leet");
			dict.add("code");
			boolean b = new F2FRound3Q2().isWordBreakable(str, dict, 0);
			if(b){
				System.out.println("Its");
			}else{
				System.out.println("Its Not");
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	
	public boolean isWordBreakable(String str,HashSet<String> dict,int start){
		try{
			if(str.length() == start){
				return true;
			}
			
			for(String word : dict){
				int i = word.length();
				int end = i+start;
				String s = str.substring(start,end);
				if(s.equals(word)){
					if(isWordBreakable(str, dict, end)){
						return true;
					}
				}
			}
			return false;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
	
	
	
}
