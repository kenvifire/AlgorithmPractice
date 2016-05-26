package ds;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;

/**
 * Created by kenvi on 16/5/25.
 */
public class H_BalancedTrees_MedianUpdates {
    public static void main(String[] args) throws Exception {
        long startTime = System.currentTimeMillis();
        AvlTree<Integer> root = new AvlTree<Integer>();

        File file = new File("/tmp/in");
        InputStream in = new FileInputStream(file);
        Scanner scanner = new Scanner(file);
        int N = scanner.nextInt();
        String str = null;
        int x;
        scanner.nextLine();
        while(N --> 0) {
            str = scanner.nextLine();

            x = Integer.valueOf(str.substring(2,str.length()));
            if(str.charAt(0) == 'a') {
                root.insertWithCount(x);
            }else {
                boolean result = root.removeWithCount(x);
                if(!result) {
                    System.out.println("Wrong!");
                    continue;
                }
            }
            List<Integer> median = root.getMedian();
            if(median == null || median.size() == 0) {
                System.out.println("Wrong!");
            }
            else if(median.size() == 1) {
                System.out.println(median.get(0));
            }else {
                long total = median.get(0).longValue() + median.get(1).longValue();
                if(total %2 != 0) {
                    System.out.printf("%.1f\n", total / 2.0);
                }else {
                    System.out.println(total / 2);
                }
            }

        }
        long end = System.currentTimeMillis();
        System.out.println("time taken :" + (end-startTime));


    }

    /**
     * Implements an AVL tree.
     * Note that all "matching" is based on the compareTo method.
     * @author Mark Allen Weiss
     */
    static class AvlTree<AnyType extends Comparable<? super AnyType>>
    {
        /**
         * Construct the tree.
         */
        public AvlTree( )
        {
            root = null;
        }

        /**
         * Insert into the tree; duplicates are ignored.
         * @param x the item to insert.
         */
        public void insert( AnyType x )
        {
            root = insert( x, root );
        }

        /**
         * Remove from the tree. Nothing is done if x is not found.
         * @param x the item to remove.
         */
        public void remove( AnyType x )
        {
            root = remove( x, root );
        }


        /**
         * Internal method to remove from a subtree.
         * @param x the item to remove.
         * @param t the node that roots the subtree.
         * @return the new root of the subtree.
         */
        private AvlNode<AnyType> remove( AnyType x, AvlNode<AnyType> t )
        {
            if( t == null )
                return t;   // Item not found; do nothing

            int compareResult = x.compareTo( t.element );

            if( compareResult < 0 )
                t.left = remove( x, t.left );
            else if( compareResult > 0 )
                t.right = remove( x, t.right );
            else if( t.left != null && t.right != null ) // Two children
            {
                t.element = findMin( t.right ).element;
                t.right = remove( t.element, t.right );
            }
            else
                t = ( t.left != null ) ? t.left : t.right;
            return balance( t );
        }

        /**
         * Find the smallest item in the tree.
         * @return smallest item or null if empty.
         */
        public AnyType findMin( )
        {
            if( isEmpty( ) )
                throw new RuntimeException( );
            return findMin( root ).element;
        }

        /**
         * Find the largest item in the tree.
         * @return the largest item of null if empty.
         */
        public AnyType findMax( )
        {
            if( isEmpty( ) )
                throw new RuntimeException( );
            return findMax( root ).element;
        }

        /**
         * Find an item in the tree.
         * @param x the item to search for.
         * @return true if x is found.
         */
        public boolean contains( AnyType x )
        {
            return contains( x, root );
        }

        /**
         * Make the tree logically empty.
         */
        public void makeEmpty( )
        {
            root = null;
        }

        /**
         * Test if the tree is logically empty.
         * @return true if empty, false otherwise.
         */
        public boolean isEmpty( )
        {
            return root == null;
        }

        /**
         * Print the tree contents in sorted order.
         */
        public void printTree( )
        {
            if( isEmpty( ) )
                System.out.println( "Empty tree" );
            else
                printTree( root );
        }

        private static final int ALLOWED_IMBALANCE = 1;

        // Assume t is either balanced or within one of being balanced
        private AvlNode<AnyType> balance( AvlNode<AnyType> t )
        {
            if( t == null )
                return t;

            if( height( t.left ) - height( t.right ) > ALLOWED_IMBALANCE )
                if( height( t.left.left ) >= height( t.left.right ) )
                    t = rotateWithLeftChild( t );
                else
                    t = doubleWithLeftChild( t );
            else
            if( height( t.right ) - height( t.left ) > ALLOWED_IMBALANCE )
                if( height( t.right.right ) >= height( t.right.left ) )
                    t = rotateWithRightChild( t );
                else
                    t = doubleWithRightChild( t );

            t.height = Math.max( height( t.left ), height( t.right ) ) + 1;
            return t;
        }

        public void checkBalance( )
        {
            checkBalance( root );
        }

        private int checkBalance( AvlNode<AnyType> t )
        {
            if( t == null )
                return -1;

            if( t != null )
            {
                int hl = checkBalance( t.left );
                int hr = checkBalance( t.right );
                if( Math.abs( height( t.left ) - height( t.right ) ) > 1 ||
                        height( t.left ) != hl || height( t.right ) != hr )
                    System.out.println( "OOPS!!" );
            }

            return height( t );
        }


        /**
         * Internal method to insert into a subtree.
         * @param x the item to insert.
         * @param t the node that roots the subtree.
         * @return the new root of the subtree.
         */
        private AvlNode<AnyType> insert( AnyType x, AvlNode<AnyType> t )
        {
            if( t == null )
                return new AvlNode<>( x, null, null );

            int compareResult = x.compareTo( t.element );

            if( compareResult < 0 )
                t.left = insert( x, t.left );
            else if( compareResult > 0 )
                t.right = insert( x, t.right );
            else
                ;  // Duplicate; do nothing
            return balance( t );
        }

        /**
         * Internal method to find the smallest item in a subtree.
         * @param t the node that roots the tree.
         * @return node containing the smallest item.
         */
        private AvlNode<AnyType> findMin( AvlNode<AnyType> t )
        {
            if( t == null )
                return t;

            while( t.left != null )
                t = t.left;
            return t;
        }

        /**
         * Internal method to find the largest item in a subtree.
         * @param t the node that roots the tree.
         * @return node containing the largest item.
         */
        private AvlNode<AnyType> findMax( AvlNode<AnyType> t )
        {
            if( t == null )
                return t;

            while( t.right != null )
                t = t.right;
            return t;
        }

        /**
         * Internal method to find an item in a subtree.
         * @param x is item to search for.
         * @param t the node that roots the tree.
         * @return true if x is found in subtree.
         */
        private boolean contains( AnyType x, AvlNode<AnyType> t )
        {
            while( t != null )
            {
                int compareResult = x.compareTo( t.element );

                if( compareResult < 0 )
                    t = t.left;
                else if( compareResult > 0 )
                    t = t.right;
                else
                    return true;    // Match
            }

            return false;   // No match
        }

        /**
         * Internal method to print a subtree in sorted order.
         * @param t the node that roots the tree.
         */
        private void printTree( AvlNode<AnyType> t )
        {
            if( t != null )
            {
                printTree( t.left );
                System.out.println( t.element );
                printTree( t.right );
            }
        }

        /**
         * Return the height of node t, or -1, if null.
         */
        private int height( AvlNode<AnyType> t )
        {
            return t == null ? -1 : t.height;
        }

        /**
         * Rotate binary tree node with left child.
         * For AVL trees, this is a single rotation for case 1.
         * Update heights, then return new root.
         */
        private AvlNode<AnyType> rotateWithLeftChild( AvlNode<AnyType> k2 )
        {
            AvlNode<AnyType> k1 = k2.left;
            k2.left = k1.right;
            k1.right = k2;
            k2.height = Math.max( height( k2.left ), height( k2.right ) ) + 1;
            k1.height = Math.max( height( k1.left ), k2.height ) + 1;
            return k1;
        }

        /**
         * Rotate binary tree node with right child.
         * For AVL trees, this is a single rotation for case 4.
         * Update heights, then return new root.
         */
        private AvlNode<AnyType> rotateWithRightChild( AvlNode<AnyType> k1 )
        {
            AvlNode<AnyType> k2 = k1.right;
            k1.right = k2.left;
            k2.left = k1;
            k1.height = Math.max( height( k1.left ), height( k1.right ) ) + 1;
            k2.height = Math.max( height( k2.right ), k1.height ) + 1;
            return k2;
        }

        /**
         * Double rotate binary tree node: first left child
         * with its right child; then node k3 with new left child.
         * For AVL trees, this is a double rotation for case 2.
         * Update heights, then return new root.
         */
        private AvlNode<AnyType> doubleWithLeftChild( AvlNode<AnyType> k3 )
        {
            k3.left = rotateWithRightChild( k3.left );
            return rotateWithLeftChild( k3 );
        }

        /**
         * Double rotate binary tree node: first right child
         * with its left child; then node k1 with new right child.
         * For AVL trees, this is a double rotation for case 3.
         * Update heights, then return new root.
         */
        private AvlNode<AnyType> doubleWithRightChild( AvlNode<AnyType> k1 )
        {
            k1.right = rotateWithLeftChild( k1.right );
            return rotateWithRightChild( k1 );
        }

        private static class AvlNode<AnyType>
        {
            // Constructors
            AvlNode( AnyType theElement )
            {
                this( theElement, null, null );
            }

            AvlNode( AnyType theElement, AvlNode<AnyType> lt, AvlNode<AnyType> rt )
            {
                element  = theElement;
                left     = lt;
                right    = rt;
                height   = 0;
            }

            AnyType           element;      // The data in the node
            AvlNode<AnyType>  left;         // Left child
            AvlNode<AnyType>  right;        // Right child
            int               height;       // Height
        }

        /** The tree root. */
        private AvlNode<AnyType> root;
        public Map<AnyType,Integer> countMap = new HashMap<AnyType, Integer>();
        public int total = 0;

        public boolean insertWithCount(AnyType x) {
            total++;
            Integer value = countMap.get(x);
            if(value == null) {
                countMap.put(x, 1);
                insert(x);
                return true;
            }else {
                value = value + 1;
                countMap.put(x, value);
                return true;
            }
        }

        public boolean removeWithCount(AnyType x) {
            Integer value = countMap.get(x);

            if(value != null) {
                total--;
                value = value -1;
                countMap.put(x, value);
                if(value == 0) {
                    //remove(x);
                    countMap.remove(x);
                }
                return true;
            }else {
                return false;
            }
        }

        public List<AnyType> getMedian() {
            return getMedian(root);
        }

        private  List<AnyType> getMedian(AvlNode<AnyType> root) {
            if(root == null) return null;
            Stack<AvlNode<AnyType>> stack = new Stack<>();

            stack.push(root);
            List<AnyType> median = new ArrayList<AnyType>(2);

            int current = 0;
            int index = total/2;
            boolean even = (total%2==0);
            AvlNode<AnyType> currentNode  = root;
            while(!stack.isEmpty() || currentNode != null) {
                if(currentNode != null) {
                    stack.push(currentNode);
                    currentNode = currentNode.left;
                }else {
                    AvlNode<AnyType> top = stack.pop();
                    current += countMap.get(top.element);
                    if(!even) {
                        if(current >= index+1) {
                            median.add(top.element);
                            return median;
                        }

                    } else  {
                        if(current >= index + 1) {
                            median.add(top.element);
                            median.add(top.element);
                            return median;
                        }else if(current >=index) {
                            median.add(top.element);
                            if(median.size() >= 2) return median;
                        }
                    }

                    currentNode = top.right;

                }

            }
            return median;
        }


    }



}

