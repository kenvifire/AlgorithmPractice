package Leecode;

import lib.TreeNode;
import utils.AssertUtils;
import utils.TreeUtils;

import java.util.HashMap;
import java.util.Map;

public class Prob_979 {
    Map<TreeNode, Integer> nodeCntMap;
    Map<TreeNode, Integer> nodeCoinCntMap;
    Map<TreeNode, Integer> subTreeCoinCntMap;

    int count = 0;

    public int distributeCoins(TreeNode root) {
        nodeCntMap = new HashMap<>();
        nodeCoinCntMap = new HashMap<>();
        subTreeCoinCntMap = new HashMap<>();
        count = 0;

        cntCoins(root);
        countNodes(root);
        distribute(root);
        return count;
    }

    private void distribute(TreeNode root) {
        if (root == null) return;

        if (root.left != null) {

            int leftCoinCnt = subTreeCoinCntMap.getOrDefault(root.left, 0);
            int leftNodeCnt = nodeCntMap.getOrDefault(root.left, 0);
            int leftDelta = leftNodeCnt - leftCoinCnt;

            if (leftDelta > 0) {
                count += leftDelta;
                addCoin(root.left, -leftDelta);
                addCoin(root, leftDelta);
            } else if (leftDelta < 0) {
                count += -leftDelta;
                addCoin(root.left, -leftDelta);
                addCoin(root, leftDelta);
            }

            distribute(root.left);
        }

        if (root.right != null) {
            int rightCoinCnt = subTreeCoinCntMap.getOrDefault(root.right, 0);

            int rightNodeCnt = nodeCntMap.getOrDefault(root.right, 0);

            int rightDelta = rightNodeCnt - rightCoinCnt;


            if (rightDelta > 0) {
                count += rightDelta;
                addCoin(root.right, -rightDelta);
                addCoin(root, rightDelta);
            }


            if (rightDelta < 0) {
                count += -rightDelta;
                addCoin(root.right, -rightDelta);
                addCoin(root, rightDelta);
            }

            distribute(root.right);

        }



    }

    private void addCoin(TreeNode treeNode, int cnt) {
        int nodeCnt = nodeCoinCntMap.getOrDefault(treeNode, 0);
        nodeCoinCntMap.put(treeNode, nodeCnt + cnt);

        int subTreeCnt = subTreeCoinCntMap.getOrDefault(treeNode, 0);
        subTreeCoinCntMap.put(treeNode, subTreeCnt + cnt);
    }

    private int countNodes(TreeNode root) {
        if (root == null) return 0;

        int cnt = 1 + countNodes(root.left) + countNodes(root.right);
        nodeCntMap.put(root, cnt);
        return cnt;
    }

    private int cntCoins(TreeNode root) {
        if (root == null) return 0;

        int cnt = root.val + cntCoins(root.left) + cntCoins(root.right);
        nodeCoinCntMap.put(root, root.val);
        subTreeCoinCntMap.put(root, cnt);
        return cnt;
    }

    public static void main(String[] args) {
        Prob_979 prob = new Prob_979();
        AssertUtils.equals(2, prob.distributeCoins(TreeUtils.fromString("[3,0,0]")));
        AssertUtils.equals(3, prob.distributeCoins(TreeUtils.fromString("[0,3,0]")));
        AssertUtils.equals(4, prob.distributeCoins(TreeUtils.fromString("[1,0,0,null,3]")));
    }
}
