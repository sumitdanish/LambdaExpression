package test4;
import java.util.function.Function;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Function<Integer, Integer> f1 = x -> x*x;
		Function<Integer, Integer> f2 = x -> x+1;
		
		Function<Integer, Integer> f11 = f1.andThen(f2);
		Function<Integer, Integer> f21 = f1.compose(f2);
		
		System.out.println(f11.apply(5));
		
		// Chain function
		System.out.println((((Function<Integer,Integer>)(x -> x*x)).andThen(x->x+1).andThen(x -> x*x)).apply(3));
		
	}
}
