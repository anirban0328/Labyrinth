package labyrinth;

public class Node {

	private int row;

	private int col;

	private String val;

	private Node north;

	private Node south;

	private Node east;

	private Node west;

	Node() {

	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		this.val = val;
	}

	public Node getNorth() {
		return north;
	}

	public void setNorth(Node north) {
		this.north = north;
	}

	public Node getSouth() {
		return south;
	}

	public void setSouth(Node south) {
		this.south = south;
	}

	public Node getEast() {
		return east;
	}

	public void setEast(Node east) {
		this.east = east;
	}

	public Node getWest() {
		return west;
	}

	public void setWest(Node west) {
		this.west = west;
	}

}
