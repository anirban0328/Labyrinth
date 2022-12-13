package labyrinth;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MainProcessor {

	/**
	 * Main Entry point of the application
	 * 
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {

		// Parse Input
		Scanner in = new Scanner(System.in);
		System.out.print(Constants.FILEINPUT);
		String fileName = in.nextLine();
		if (fileName == null || fileName.isEmpty()) {
			in.close();
			System.out.println(Constants.APPEXIT);
			return;
		}

		fileName = fileName.trim();
		FileReader reader = new FileReader(fileName + ".txt");
		Scanner in2 = new Scanner(reader);

		// Build the Map
		Map<String, Node> inputMap = new TreeMap<>();
		while (in2.hasNextLine()) {
			String nextLine = in2.nextLine();
			BuildMap buildMap = new BuildMap();
			buildMap.createMap(nextLine, inputMap);
		}

		// Create Labyrinth
		int len = inputMap.size();
		String[][] displayArr = new String[len][len];
		CreateLabyrinth createLabyrinth = new CreateLabyrinth();
		createLabyrinth.createLabyrinth(displayArr, inputMap);

		// Get starting position
		String curr = inputMap.keySet().stream().findFirst().get();
		Node currElement = inputMap.get(curr);

		// Display Labyrinth
		DisplayLabyrinth displayLabyrinth = new DisplayLabyrinth();
		Utils util = new Utils();
		while (true) {
			displayLabyrinth.displayLabyrinth(inputMap.size(), displayArr);
			System.out.println(Constants.CURRENTROOM + curr);
			System.out.println(Constants.POSSIBLEMOVES + util.getPossibleMoves(currElement));
			System.out.print(Constants.CHOICES);
			String inputMoves = in.nextLine();
			curr = util.parseMoves(curr, currElement, inputMoves, inputMap);
			if (curr == null) {
				System.out.println(Constants.APPEXIT);
				break;
			}
			currElement = inputMap.get(curr);
		}

		// Close Scanner
		in.close();
		in2.close();
	}
}
