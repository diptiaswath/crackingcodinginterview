// https://leetcode.com/problems/copy-list-with-random-pointer/
class CopyListWithRandomPointer {
    private Map<Node, Node> visited = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (visited.containsKey(head)) {
            return visited.get(head);
        }
        Node clonedNode = new Node(head.val, null, null);
        visited.put(head, clonedNode);

        clonedNode.next = copyRandomList(head.next);
        clonedNode.random = copyRandomList(head.random);
        return clonedNode;
    }
}