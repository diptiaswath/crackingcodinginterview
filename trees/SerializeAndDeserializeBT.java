package design;
// https://leetcode.com/problems/serialize-and-deserialize-binary-tree/editorial/
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class SerializeAndDeserializeBT {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return recurseSerialize(root, "");
    }

    private String recurseSerialize(TreeNode root, String str) {
        if (root == null) {
            str += "null,";
            return str;
        }
        str += String.valueOf(root.val) + ",";
        str = recurseSerialize(root.left, str);
        str = recurseSerialize(root.right, str);
        return str;
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] datas = data.split(",");
        List<String> dataList = new ArrayList<>(Arrays.asList(datas));
        return recurseDeserialize(dataList);
    }

    private TreeNode recurseDeserialize(List<String> dataList) {
        if (dataList.get(0).equals("null")) {
            dataList.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(dataList.get(0)));
        dataList.remove(0);
        root.left = recurseDeserialize(dataList);
        root.right = recurseDeserialize(dataList);
        return root;
    }
}
