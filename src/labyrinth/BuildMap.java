package labyrinth;

import java.util.Map;

public class BuildMap {

	/**
	 * Create TreeMap to store value, location and next pointers
	 * 
	 * @param nextLine
	 * @param inputMap
	 */
	public void createMap(String nextLine, Map<String, Node> inputMap) {
		String[] line = nextLine.split(" ");
		String nodeName = line[0];

		Node n = null;
		if (inputMap.containsKey(nodeName)) {
			n = inputMap.get(nodeName);
		} else {
			n = new Node();
			n.setVal(nodeName);
		}

		for (int i = 1; i < line.length; i++) {
			String[] neighbour = line[i].split(":");
			String direction = neighbour[0];
			String neighbourName = neighbour[1];

			if (direction.equals("n")) {
				if (!inputMap.containsKey(neighbourName)) {
					Node neighbourNode = new Node();
					neighbourNode.setVal(neighbour[1]);
					n.setNorth(neighbourNode);
				} else {
					n.setNorth(inputMap.get(neighbourName));
				}
			} else if (direction.equals("s")) {
				if (!inputMap.containsKey(neighbourName)) {
					Node neighbourNode = new Node();
					neighbourNode.setVal(neighbour[1]);
					n.setSouth(neighbourNode);
				} else {
					n.setSouth(inputMap.get(neighbourName));
				}
			} else if (direction.equals("e")) {
				if (!inputMap.containsKey(neighbourName)) {
					Node neighbourNode = new Node();
					neighbourNode.setVal(neighbour[1]);
					n.setEast(neighbourNode);
				} else {
					n.setEast(inputMap.get(neighbourName));
				}
			} else if (direction.equals("w")) {
				if (!inputMap.containsKey(neighbourName)) {
					Node neighbourNode = new Node();
					neighbourNode.setVal(neighbour[1]);
					n.setWest(neighbourNode);
				} else {
					n.setWest(inputMap.get(neighbourName));
				}
			}
		}
		inputMap.put(nodeName, n);
	}
}
