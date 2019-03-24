import java.util.Scanner;
import java.util.Vector;

public class Stocks {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		int points = in.nextInt();
		int n = in.nextInt() - 1;
		int m = in.nextInt() - 1;
		in.nextLine();

		int peaks = 0;
		int valley = 0;

		Vector<Integer> prices = new Vector<>();
		for(int i = 0; i < points; i++){
			prices.add(in.nextInt());
		}


		for(int x = 0; x < points; x++) {
			boolean isValley = true;
			boolean isPeak = true;

			if(x > m) {
				for (int i = m; i < points - m; i++) {
					//isValley
					for (int j = 0; j < m; j++) {
						if (prices.get(i - j) > prices.get(i - j - 1)) {
							isValley = false;
							break;
						}
						if (prices.get(i + j) > prices.get(i + j + 1)) {
							isValley = false;
							break;
						}
					}
				}
			}

			if(x > n) {
				for (int i = n; n < points - n; n++) {
					//isPeak
					for (int j = 0; j < n; j++) {
						if (prices.get(i - j) < prices.get(i - j - 1)) {
							isPeak = false;
							break;
						}
						if (prices.get(i + j) < prices.get(i + j + 1)) {
							isPeak = false;
							break;
						}
					}
				}
			}

			if (isPeak)
				peaks++;
			if (isValley)
				valley++;
		}

		System.out.println(peaks + " " + valley);
	}
}
