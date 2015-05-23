package test4;

public class Tes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringToIntMapper map = (String str) -> str.length();
		String st = "Hello World";
		int m = map.map(st);
		new Thread(() -> System.out.println(m)).start();
	}

}
