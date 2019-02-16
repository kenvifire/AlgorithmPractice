package Leecode;

public class Prob_405 {
    private String hex = "0123456789abcdef";
    public String toHex(int num) {
        if(num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        if(num > 0) {
            while (num > 0) {
                sb.append(hex.charAt(num % 16 ));
                num /= 16;
            }
        } else {
            long neg = ~(-num) + 1;
            int cnt = 8;
            while (cnt > 0) {
                sb.append(hex.charAt((int)(neg & 0x0f)));
                neg >>>= 4;
                cnt--;
            }
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Prob_405 prob = new Prob_405();
        System.out.println(prob.toHex(-3456));
    }
}
