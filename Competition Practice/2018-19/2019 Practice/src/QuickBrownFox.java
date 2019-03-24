import java.util.*;
import java.util.regex.Pattern;

public class QuickBrownFox {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		int lines = in.nextInt();
		in.nextLine();

		for(int i = 0; i < lines; i++){
			HashMap<Character, Integer> letters = new HashMap<>();

			for(int j = 0; j < 27; j++){
				letters.put((char)('a' + j), 0);
			}

			String line = in.nextLine().toLowerCase();
			line = line.replace(".", "");
			line = line.replace(",", "");
			line = line.replace("?", "");
			line = line.replace("!", "");
			line = line.replace("'", "");
			line = line.replace("\"", "");
			line = line.replace(" ", "");
			line = line.replace("1", "");
			line = line.replace("2", "");
			line = line.replace("3", "");
			line = line.replace("4", "");
			line = line.replace("5", "");
			line = line.replace("6", "");
			line = line.replace("7", "");
			line = line.replace("8", "");
			line = line.replace("9", "");
			line = line.replace("0", "");

			for(int j = 0; j < line.length(); j++){
				Character letter = line.charAt(j);
				letters.put(letter, letters.get(letter) + 1);
			}

			boolean isPangram = true;
			StringBuilder missing = new StringBuilder();
			for(int j = 0; j < 26; j++){
				if(letters.get((char)('a' + j)) == 0){
					isPangram = false;
					missing.append((char)('a' + j));
				}
			}

			String miss = missing.toString();

			if(isPangram)
				System.out.println("pangram");
			else
				System.out.println("missing " + miss);
		}
	}
}
