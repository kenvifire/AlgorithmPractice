import java.util.Scanner;
import java.util.Stack;

/**
 * Created by hannahzhang on 16/5/7.
 */
public class H_BalancedParantheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        while ( T--> 0) {
            String input = scanner.next();
            Stack<Character> stack = new Stack<Character>();
            int i = 0;
            boolean balance = true;
            while (i < input.length()) {
                char c = input.charAt(i);
                if(c == '}' || c == ']' || c == ')')  {
                    if(stack.isEmpty()) {
                        balance = false;
                        break;
                    }else {
                        char top = stack.peek();
                        if((c == '}' && top =='{') ||
                                (c == ')' && top =='(') ||
                                (c ==']' && top == '[')){
                            stack.pop();
                        }else {
                            balance = false;
                            break;
                        }

                    }
                }else {
                    stack.push(c);
                }
                i++;
            }

            System.out.println((balance && stack.isEmpty()) ?"YES" : "NO");

        }
    }
}
