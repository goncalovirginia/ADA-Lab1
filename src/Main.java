import java.io.IOException;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws IOException {
		TurboScanner in = new TurboScanner(System.in);
		int r = in.nextInt(), c = in.nextInt();
		
		LegoMosaics legoMosaics = new LegoMosaics(r, c);
		
		for (int i = 0; i < r; i++) {
			legoMosaics.addRow(in.nextLine());
		}
		
		System.out.println(legoMosaics.getTotalCombinations());
		in.close();
	}
	
}
