package wangqi.data.model;

import java.util.ArrayList;
import java.util.List;

public class UndirectedGraphNode {
	private int label;
	private List<UndirectedGraphNode> neighbours;

	public UndirectedGraphNode(int x) {
		label = x;
		neighbours = new ArrayList<UndirectedGraphNode>();
	}

	public int getLabel() {
		return label;
	}

	public void setLabel(int label) {
		this.label = label;
	}

	public List<UndirectedGraphNode> getNeighbours() {
		return neighbours;
	}

	public void setNeighbours(List<UndirectedGraphNode> neighbours) {
		this.neighbours = neighbours;
	}
}
