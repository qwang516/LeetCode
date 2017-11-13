package wangqi.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import wangqi.data.model.UndirectedGraphNode;

/*
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 */
public class CloneGraph {
	// Breadth-First Search
	public UndirectedGraphNode cloneGraphByBreadthFirst(UndirectedGraphNode node) {
		if (node == null) {
			return null;
		}
		LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
		Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		queue.offer(node);
		UndirectedGraphNode copy = new UndirectedGraphNode(node.getLabel());
		map.put(node, copy);
		while (!queue.isEmpty()) {
			UndirectedGraphNode curNode = queue.poll();
			for (UndirectedGraphNode neighbour : curNode.getNeighbours()) {
				if (!map.containsKey(neighbour)) {
					copy = new UndirectedGraphNode(neighbour.getLabel());
					map.put(neighbour, copy);
					queue.offer(neighbour);
				}
				map.get(curNode).getNeighbours().add(neighbour);
			}
		}
		return map.get(node);
	}

	// Depth-First Search
	public UndirectedGraphNode cloneGraphByDepthFirst(UndirectedGraphNode node) {
		if (node == null) {
			return null;
		}
		LinkedList<UndirectedGraphNode> stack = new LinkedList<UndirectedGraphNode>();
		Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		stack.push(node);
		UndirectedGraphNode copy = new UndirectedGraphNode(node.getLabel());
		map.put(node, copy);
		while (!stack.isEmpty()) {
			UndirectedGraphNode curNode = stack.pop();
			for (UndirectedGraphNode neighbour : curNode.getNeighbours()) {
				if (!map.containsKey(neighbour)) {
					copy = new UndirectedGraphNode(neighbour.getLabel());
					map.put(neighbour, copy);
					stack.push(neighbour);
				}
				map.get(curNode).getNeighbours().add(neighbour);
			}
		}
		return null;
	}
}
