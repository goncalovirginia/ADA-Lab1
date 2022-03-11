import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		System.nanoTime();
		
		Scanner in = new Scanner(System.in);
		int r = in.nextInt(), c = in.nextInt();
		in.nextLine();
		
		int totalCombinations = 1;
		
		for (int i = 0; i < r; i++) {
			totalCombinations *= rowCombinations(in.nextLine(), c);
		}
		
		System.out.println(totalCombinations);
	}
	
	private static int rowCombinations(String row, int c) {
		int rowCombinations = 1;
		int i = 0;
		
		while (i < c) {
			if (row.charAt(i) == '.') {
				i++;
			}
			else {
				int colorSegmentStartIndex = i++;
				
				while (i < c && row.charAt(colorSegmentStartIndex) == row.charAt(i)) {
					i++;
				}
				
				rowCombinations *= Math.pow(2, i - colorSegmentStartIndex - 1);
			}
		}
		
		return rowCombinations;
	}
	
}
