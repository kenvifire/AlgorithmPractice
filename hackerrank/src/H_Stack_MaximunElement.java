import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by hannahzhang on 16/5/7.
 */
public class H_Stack_MaximunElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack<Integer>();
        int N;
        N = scanner.nextInt();

        int type;
        int x;
        int max = Integer.MIN_VALUE;
        while( N--> 0) {
            type = scanner.nextInt();

            if( type == 1) {
                x = scanner.nextInt();
                if(x > max) {
                    max = x;
                }
                stack.push(x);
            }else if (type == 2) {
                int top = stack.pop();
                if(top == max) {
                    max = Integer.MIN_VALUE;
                    Iterator<Integer> iterator = stack.iterator();
                    while(iterator.hasNext()) {
                        int e = iterator.next();
                        if(e > max) {
                            max = e;
                        }
                    }
                }

            }else if(type == 3) {
                System.out.println(max);
            }
        }

    }
}
