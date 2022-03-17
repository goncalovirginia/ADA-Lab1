import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LegoMosaics {
	
	private static final int[] BRICK_LENGTHS = {16, 12, 10, 8, 6, 4, 3, 2, 1};
	
	private int[] ways;
	private int rows, columns, totalCombinations, calculatedUpTo;
	
	public LegoMosaics(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		ways = new int[this.columns + 1];
		ways[0] = 1;
		calculatedUpTo = 0;
		totalCombinations = 1;
	}
	
	
	public void addRow(String row) {
		int rowCombinations = 1, column = 0, colorSegmentStartIndex;
		
		while (column < columns) {
			if (row.charAt(column) == '.') {
				column++;
			}
			else {
				colorSegmentStartIndex = column;
				
				do {
					column++;
				} while (column < columns && row.charAt(colorSegmentStartIndex) == row.charAt(column));
				
				rowCombinations *= colorSegmentCombinations(column - colorSegmentStartIndex);
			}
		}
		
		totalCombinations *= rowCombinations;
	}
	
	private int colorSegmentCombinations(int colorSegmentLength) {
		while (calculatedUpTo < colorSegmentLength) {
			calculatedUpTo++;
			
			for (int i : BRICK_LENGTHS) {
				if (calculatedUpTo - i >= 0) {
					ways[calculatedUpTo] += ways[calculatedUpTo - i];
				}
			}
		}
		
		return ways[colorSegmentLength];
	}
	
	public int getTotalCombinations() {
		return totalCombinations;
	}
	
}
