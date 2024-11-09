// https://leetcode.com/problems/binary-tree-paths/
public class TraversePaths {
    private void traversePaths(TreeNode node, StringBuilder path, LinkedList<String> paths) {
        if (node == null) {
            return;
        }
        // Record the current length of the path
        int length = path.length();

        // Add current node to path
        path.append(Integer.toString(node.val));

        // Base case when to return
        if (node.left == null && node.right == null) {
            paths.add(path.toString());
        }

        path.append("->");
        traversePaths(node.left, path, paths);
        traversePaths(node.right, path, paths);

        // Revert the StringBuilder to its previous state
        path.setLength(length);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        LinkedList<String> paths = new LinkedList<>();
        traversePaths(root, new StringBuilder(), paths);
        return paths;
    }
}