import java.util.Scanner;

public class SimonSays {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		int lines = in.nextInt();
		in.nextLine();

		for(int i = 0; i < lines; i++){
			String line = in.nextLine();

			int location = line.indexOf("Simon says ");

			if(location != -1){
				System.out.println(line.substring(10));
			}
		}
	}
}
