package Leecode;

public class Prob_717 {
    public boolean isOneBitCharacter(int[] bits) {
        if(bits.length == 1) return true;
        return canSplit(bits, 0, bits.length - 2);
    }

    private boolean canSplit(int[] bits, int start, int end) {
        if(start > end) return true;
        if(start == end) return bits[start] == 0;
        if(end - start == 1) return (bits[start] == 1) || (bits[start] == 0 && bits[end]==0 ) ;

        if(bits[end] == 1) {
            return bits[end-1] == 1 && canSplit(bits, start, end - 2) ;
        } else {
            return canSplit(bits, start, end - 1) || canSplit(bits, start, end -2);

        }

    }

    public static void main(String[] args) {
        System.out.println(new Prob_717().isOneBitCharacter(new int[] {1, 1, 0}));
        System.out.println(new Prob_717().isOneBitCharacter(new int[] {1, 1, 1, 0}));
        System.out.println(new Prob_717().isOneBitCharacter(new int[] {0}));
        System.out.println(new Prob_717().isOneBitCharacter(new int[] {0, 0 , 0}));
        System.out.println(new Prob_717().isOneBitCharacter(new int[] {1, 0 , 0}));
        System.out.println(new Prob_717().isOneBitCharacter(new int[] {0, 1 , 0}));
        System.out.println(new Prob_717().isOneBitCharacter(new int[] {1,1,0,0}));
        System.out.println(new Prob_717().isOneBitCharacter(new int[] {0,0, 0, 0}));//true
        System.out.println(new Prob_717().isOneBitCharacter(new int[] {0,0, 1, 0}));//false
        System.out.println(new Prob_717().isOneBitCharacter(new int[] {0,1, 0, 0}));//true
        System.out.println(new Prob_717().isOneBitCharacter(new int[] {0,1, 1, 0}));//true
        System.out.println(new Prob_717().isOneBitCharacter(new int[] {1,0, 0, 0}));//true
        System.out.println(new Prob_717().isOneBitCharacter(new int[] {1,0, 1, 0}));//false
        System.out.println(new Prob_717().isOneBitCharacter(new int[] {1,1, 0, 0}));//true
        System.out.println(new Prob_717().isOneBitCharacter(new int[] {1,1, 1, 0}));//false
    }
}
