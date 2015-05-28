package test4;

import java.util.Scanner;
import java.util.function.Function;
import java.lang.FunctionalInterface;
public class Tes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		StringToIntMapper map = (String str) -> str.length();
//		String st = "Hello World";
//		int m = map.map(st);
//		new Thread(() -> System.out.println(m)).start();
		/*Operations op = (x,y) -> x+y;
		double d = op.add(2.3, 2.4);
		System.out.println(d);*/
		
		Function<Long,Long> f = x -> x*x;
		System.out.println(f.apply((long) 5));
		
	}
	public PassswordEncoder makePaasword(){
		return (pass,salt) -> pass.toUpperCase();
	}
}
