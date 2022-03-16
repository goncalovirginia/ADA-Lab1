import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int r = in.nextInt(), c = in.nextInt();
		in.nextLine();
		
		LegoMosaics legoMosaics = new LegoMosaics(r, c);
		
		for (int i = 0; i < r; i++) {
			legoMosaics.addRow(in.nextLine());
		}
		
		System.out.println(legoMosaics.getTotalCombinations());
		in.close();
	}
	
}
