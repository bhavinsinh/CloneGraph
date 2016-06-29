package com.bhavinc;

import java.util.*;

public class Main {
    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        UndirectedGraphNode nodeB = new UndirectedGraphNode(node.label);
        UndirectedGraphNode nodeT;
        Map<UndirectedGraphNode , UndirectedGraphNode> visited = new HashMap<>();
        visited.put(node, nodeB);
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.add(node);
        UndirectedGraphNode cloneNode = null;
        while (!queue.isEmpty()) {
            nodeT = queue.remove();
            cloneNode = visited.get(nodeT);
            for (UndirectedGraphNode neighbor : nodeT.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    UndirectedGraphNode newNodeB = new UndirectedGraphNode(neighbor.label);
                    visited.put(neighbor, newNodeB);
                    queue.add(neighbor);
                    cloneNode.neighbors.add(newNodeB);
                } else {
                    UndirectedGraphNode neighborB = visited.get(neighbor);
                    cloneNode.neighbors.add(neighborB);
                }
            }
        }
        return nodeB;
    }

    public static void main(String[] args) {
        // write your code here
    }
}
