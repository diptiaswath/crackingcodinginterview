// https://leetcode.com/problems/binary-tree-vertical-order-traversal/

// Given the root of a binary tree, return the vertical order traversal of its nodes' values. (i.e., from top to bottom, column by column).
//If two nodes are in the same row and column, the order should be from left to right.
// BFS take O(N), sort is O(N LOG N)
class Pair<TreeNode, Integer> {
    TreeNode key;
    Integer val;
    Pair(TreeNode key, Integer val) {
        this.key = key;
        this.val = val;
    }
}
public class BinaryTreeVerticalOrderTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();
        if (root == null) {
            return output;
        }


        //Column Index map key = colIndex, list of node vals
        Map<Integer, List<Integer>> columnIndexMap = new HashMap<>();

        //Queue has a Pair (TreeNode + colIndex)
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();


        // add root val with columnIndex at 0
        queue.add(new Pair<TreeNode, Integer>(root, 0));

        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> cur = queue.poll();

            TreeNode curNode = cur.key;
            Integer columnIndex = cur.val;

            if (!columnIndexMap.containsKey(columnIndex)) {
                columnIndexMap.put(columnIndex, new ArrayList<>());
            }
            columnIndexMap.get(columnIndex).add(curNode.val);

            if (curNode.left != null) {
                queue.add(new Pair<>(curNode.left, columnIndex -1));
            }
            if (curNode.right != null) {
                queue.add(new Pair<>(curNode.right, columnIndex +1));
            }
        } // end of while

        List<Integer> columnIndexKeys = new ArrayList<Integer>(columnIndexMap.keySet());
        Collections.sort(columnIndexKeys);
        for (Integer colIndex: columnIndexKeys) {
            output.add(columnIndexMap.get(colIndex));
        }
        return output;
    }
}