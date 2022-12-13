package labyrinth;

public class DisplayLabyrinth {

	/**
	 * Print the Labyrinth in the console
	 * 
	 * @param len
	 * @param displayArr
	 */
	public void displayLabyrinth(int len, String[][] displayArr) {
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				if (displayArr[i][j] == null) {
					System.out.print("  ");
				} else
					System.out.print(displayArr[i][j]);
			}
			System.out.println();
		}
	}
}
