import java.util.Scanner;
import java.util.Stack;

/**
 * Created by hannahzhang on 16/5/8.
 */
public class H_Stack_SimpleTextEditor {

    static class Oper {
        int type;
        int k;
        String w;
    }

    public static void main(String[] args) {
        int Q;
        StringBuilder sb = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        Stack<Oper> operStack = new Stack<Oper>();

        Q = scanner.nextInt();
        int type;
        int k;
        String w;
        while (Q --> 0) {
            type = scanner.nextInt();
            if(type == 1) {
                Oper oper = new Oper();
                oper.type = type;
                w = scanner.next();
                oper.w = w;
                operStack.push(oper);
                sb.append(w);
            }else if( type == 2 ) {
                Oper oper = new Oper();
                oper.type = type;
                k = scanner.nextInt();
                oper.k = k;
                operStack.push(oper);
                oper.w = erase(sb, k);
            }else if (type == 3) {
                k = scanner.nextInt();
                System.out.println(sb.charAt(k-1));
            }else if (type == 4) {
                Oper oper = operStack.pop();
                if(oper.type == 1) {
                    erase(sb, oper.w.length());
                }else {
                    sb.append(oper.w);
                }

            }
        }
    }

    static String  erase(StringBuilder sb, int k) {
        String s = sb.substring(sb.length() - k, sb.length());
        sb.delete(sb.length() - k, sb.length());
        return s;

    }



}
