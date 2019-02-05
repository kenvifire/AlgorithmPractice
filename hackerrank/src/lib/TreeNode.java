package lib;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }



    public TreeNode (Integer[] array) {
        this.val = array[0];
        insertLevelOrder(array, this, 0);
    }

    private TreeNode insertLevelOrder(Integer[] array, TreeNode root, int i) {
        // Base case for recursion
        if (i < array.length) {
            TreeNode temp = array[i] == null ? null :new TreeNode(array[i]);
            root = temp;

            // insert left child
            root.left = insertLevelOrder(array, root.left,
                    2 * i + 1);

            // insert right child
            root.right = insertLevelOrder(array, root.right,
                    2 * i + 2);
        }
        return root;
    }
}
