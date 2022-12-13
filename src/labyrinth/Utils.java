package labyrinth;

import java.util.Map;

public class Utils {

	/**
	 * Get all possible moves from the given Node.
	 * 
	 * @param node
	 * @return
	 */
	public String getPossibleMoves(Node node) {
		StringBuffer possibleMoves = new StringBuffer();
		if (node.getNorth() != null)
			possibleMoves.append("n");
		if (node.getSouth() != null)
			possibleMoves.append("s");
		if (node.getEast() != null)
			possibleMoves.append("e");
		if (node.getWest() != null)
			possibleMoves.append("w");

		return possibleMoves.toString();
	}

	/**
	 * Parse user input move information.
	 * 
	 * @param curr
	 * @param currElement
	 * @param inputMoves
	 * @param inputMap
	 * @return
	 */
	public String parseMoves(String curr, Node currElement, String inputMoves, Map<String, Node> inputMap) {
		if (inputMoves == null || inputMoves.isEmpty() || inputMoves.equalsIgnoreCase(Constants.EXIT))
			return null;

		for (int i = 0; i < inputMoves.length(); i++) {
			Node next = null;
			if (inputMoves.charAt(i) == 'n') {
				next = currElement.getNorth();
			} else if (inputMoves.charAt(i) == 's') {
				next = currElement.getSouth();
			} else if (inputMoves.charAt(i) == 'e') {
				next = currElement.getEast();
			} else if (inputMoves.charAt(i) == 'w') {
				next = currElement.getWest();
			}

			if (next != null) {
				curr = next.getVal();
				currElement = inputMap.get(curr);
			} else {
				System.out.println(Constants.INVALIDMOVE);
				return null;
			}
		}
		return curr;
	}
}
