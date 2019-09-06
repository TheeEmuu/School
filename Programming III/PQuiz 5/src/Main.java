public class Main {
	public static void main(String[] args){
		BubbaHashMap<Integer, Integer> map = new BubbaHashMap<>(10);

		map.put(1, 5);
		map.put(2, 6);
		map.put(20, 8);
		map.put(31, 9);

		System.out.println(map.checkBooks());
	}
}
