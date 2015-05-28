package test4;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.*;
public class FunctionalUtil {
	
	public static <T> void forEach(ArrayList<T> list,Consumer<? super T> action){
		try{
			for(T item : list){
				action.accept(item);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public static <T> ArrayList<T> filter(ArrayList<T> list,Predicate<? super T> predicat){
		
		ArrayList<T> li = new ArrayList<>();
		for(T lt : list){
			if(predicat.test(lt)){
				li.add(lt);
			}
		}
		return li;
	}
	
	public static <T,R> ArrayList<R> map(ArrayList<T> list,Function<? super T, R> mapper){
		ArrayList<R> li1 = new ArrayList<R>();
		for(T li : list){
			li1.add(mapper.apply(li));
		}
		return li1;
	}
}
