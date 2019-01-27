package Leecode;

public class Prob_984 {
    public String strWithout3a3b(int A, int B) {
        String c1, c2;
        c1 = "a";
        c2 = "b";
        StringBuilder sb = new StringBuilder();

        if(A == B) {
            int i = 0;
            while (i < A) {
                sb.append("ab");
                i++;
            }
            return sb.toString();

        }

        if(A > B) {
            c1 = "b";
            c2 = "a";

            int temp = A;
            A = B;
            B = temp;
        }

        int extra = B - (A + 1);

        String cc = c2 + c2;

        int index = 0;

        while (index < A+1) {
            if (index <= extra) {
               sb.append(cc);
            }else {
                sb.append(c2);
            }
            sb.append(c1);
            index++;
        }
        return sb.substring(0, A + B).toString();
    }

    public static void main(String[] args) {
        System.out.println(new Prob_984().strWithout3a3b(1,2));
        System.out.println(new Prob_984().strWithout3a3b(4,1));
        System.out.println(new Prob_984().strWithout3a3b(1,4));
        System.out.println(new Prob_984().strWithout3a3b(2,5));
        System.out.println(new Prob_984().strWithout3a3b(3,3));
    }

}
