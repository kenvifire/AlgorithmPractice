package Leecode;

import java.util.BitSet;

/**
 * https://leetcode.com/problems/validate-binary-tree-nodes/
 */
public class Prob1361 {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        BitSet bs = new BitSet(n);
        for(int i = 0; i < n; i++) {
            int left = leftChild[i];
            int right = rightChild[i];

            if(left >= 0) {
                if(bs.get(left)) return false;
                bs.set(left);
            }

            if(right >= 0) {
                if(bs.get(right)) return false;
                bs.set(right);
            }
        }

        int root = -1;
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            if(!bs.get(i)) {
                root = i;
                cnt++;
            }
            if(cnt > 1) return false;
        }
        //find the root
        //if single root
        if(n == 1) return true;
        //else, check there're children for the root node
        return root >=0 && (leftChild[root] >= 0 || rightChild[root] >=0);


    }
}
