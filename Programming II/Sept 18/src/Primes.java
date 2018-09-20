public class Primes {
	public static void main(String args[]) {
		SetVector s = new SetVector();
		
		for(int i = 0; i < 100; i++) {
			s.add(i);
		}
		
		System.out.println(s);
		
		myMethod(s);
	}
	
	public static void myMethod(AbstractSet s) {
		System.out.println("Accepted the SetVector");
	}
}
