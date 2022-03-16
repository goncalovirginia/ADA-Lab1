import java.util.HashSet;
import java.util.Set;

public class LegoMosaics {
	
	private static final int[] BRICK_LENGTHS = {1, 2, 3, 4, 6, 8, 10, 12, 16};
	
	private int[] colorSegmentLengthCombinations;
	private int rows, columns, totalCombinations, calculatedColorSegmentLengthCombinations;
	private Set<Integer> brickLengths;
	
	public LegoMosaics(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		colorSegmentLengthCombinations = new int[this.columns + 1];
		colorSegmentLengthCombinations[1] = 1;
		calculatedColorSegmentLengthCombinations = 1;
		totalCombinations = 1;
		
		brickLengths = new HashSet<>();
		
		for (int i : BRICK_LENGTHS) {
			brickLengths.add(i);
		}
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
		if (colorSegmentLength > calculatedColorSegmentLengthCombinations) {
			calculateColorSegmentLengthCombinations(colorSegmentLength);
		}
		
		return colorSegmentLengthCombinations[colorSegmentLength];
	}
	
	private void calculateColorSegmentLengthCombinations(int colorSegmentLength) {
		do {
			calculatedColorSegmentLengthCombinations++;
			colorSegmentLengthCombinations[calculatedColorSegmentLengthCombinations] =
					colorSegmentLengthCombinations[calculatedColorSegmentLengthCombinations - 1] * 2;
			
			if (!brickLengths.contains(calculatedColorSegmentLengthCombinations)) {
				colorSegmentLengthCombinations[calculatedColorSegmentLengthCombinations]--;
			}
		} while (calculatedColorSegmentLengthCombinations < colorSegmentLength);
	}
	
	public int getTotalCombinations() {
		return totalCombinations;
	}
	
}
