import java.util.Scanner;

public class Main {
	
	private static final int[] BRICK_LENGTHS = {1, 2, 3, 4, 6, 8, 10, 12, 16};
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int r = in.nextInt(), c = in.nextInt();
		in.nextLine();
		
		int totalCombinations = 1;
		
		for (int i = 0; i < r; i++) {
			totalCombinations *= rowCombinations(in.nextLine(), c);
		}
		
		System.out.println(totalCombinations);
		in.close();
	}
	
	private static int rowCombinations(String row, int c) {
		int rowCombinations = 1, column = 0, colorSegmentStartIndex;
		
		while (column < c) {
			if (row.charAt(column) == '.') {
				column++;
			}
			else {
				colorSegmentStartIndex = column;
				
				do {
					column++;
				} while (column < c && row.charAt(colorSegmentStartIndex) == row.charAt(column));
				
				rowCombinations *= colorSegmentCombinations(column - colorSegmentStartIndex);
			}
		}
		
		return rowCombinations;
	}
	
	private static int colorSegmentCombinations(int colorSegmentLength) {
		if (colorSegmentLength <= 4) {
			return (int) Math.pow(2, colorSegmentLength - 1);
		}
		//TODO
		return 0;
	}
	
}
