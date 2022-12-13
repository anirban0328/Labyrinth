package labyrinth;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CreateLabyrinth {

	/**
	 * Create 2D array of the labyrinth from the input tree map
	 * 
	 * @param displayArr
	 * @param inputMap
	 */
	public void createLabyrinth(String[][] displayArr, Map<String, Node> inputMap) {
		int len = inputMap.size();
		int startRow = len / 2;
		int startCol = len / 2;
		Set<Node> visited = new HashSet<Node>();
		Queue<Node> queue = new LinkedList<Node>();
		String first = inputMap.keySet().stream().findFirst().get();
		Node firstElement = inputMap.get(first);
		firstElement.setRow(startRow);
		firstElement.setCol(startCol);
		queue.add(firstElement);

		while (!queue.isEmpty()) {
			Node element = queue.poll();
			if (!visited.contains(element)) {
				startRow = element.getRow();
				startCol = element.getCol();
				displayArr[startRow][startCol] = element.getVal();

				if (element.getNorth() != null) {
					Node north = element.getNorth();
					Node northNode = inputMap.get(north.getVal());
					displayArr[startRow - 1][startCol] = "|";
					northNode.setRow(startRow - 2);
					northNode.setCol(startCol);
					queue.add(northNode);
				}
				if (element.getSouth() != null) {
					Node south = element.getSouth();
					Node southNode = inputMap.get(south.getVal());
					displayArr[startRow + 1][startCol] = "|";
					southNode.setRow(startRow + 2);
					southNode.setCol(startCol);
					queue.add(southNode);
				}
				if (element.getEast() != null) {
					Node east = element.getEast();
					Node easthNode = inputMap.get(east.getVal());
					displayArr[startRow][startCol + 1] = "-";
					easthNode.setRow(startRow);
					easthNode.setCol(startCol + 2);
					queue.add(easthNode);
				}
				if (element.getWest() != null) {
					Node west = element.getWest();
					Node westhNode = inputMap.get(west.getVal());
					displayArr[startRow][startCol - 1] = "-";
					westhNode.setRow(startRow);
					westhNode.setCol(startCol - 2);
					queue.add(westhNode);
				}
			}
			visited.add(element);
		}
	}
}
