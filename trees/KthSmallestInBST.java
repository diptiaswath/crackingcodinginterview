// https://leetcode.com/problems/kth-smallest-element-in-a-bst/editorial/
class Solution {

    // Using DFS (Recursive) with Inorder traverse
    // O(N)
    private void inorderTraverse(TreeNode node, List<Integer> arr) {
        if (node == null) {
            return;
        }
        inorderTraverse(node.left, arr);
        arr.add(node.val);
        inorderTraverse(node.right, arr);
    }

    public int kthSmallestA1(TreeNode root, int k) {
        List<Integer> arr = new ArrayList<>();
        inorderTraverse(root, arr);
        return arr.get(k-1);
    }


    // Using Iterative Inorder traverse with Stack
    // This is O(H + k) where H = log N in a completely balanced tree and H = N otherwise
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (--k == 0) { return root.val;}
            root = root.right;
        }//outer while
    }

}
