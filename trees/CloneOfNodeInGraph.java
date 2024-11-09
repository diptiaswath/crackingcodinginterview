// https://leetcode.com/problems/clone-graph/editorial/
class CloneOfNode {
    private Map<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        Node clonedNode = new Node(node.val, new ArrayList<>());
        visited.put(node, clonedNode);

        for (Node neighbor: node.neighbors){
            visited.get(node).neighbors.add(cloneGraph(neighbor));
        }
        return clonedNode;
    }
}