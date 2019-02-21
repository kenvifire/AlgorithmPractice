package Leecode;

import utils.AssertUtils;

import java.util.Random;

public class Prob_374 {
    private  int actual;

    public Prob_374(int n, int actual) {
        this.actual= actual;
    }




    public int guessNumber(int n) {

        long left = 1, right = n;

        int result;
        while ((result = guess((int)((left + right) / 2) )) != 0) {
            if(result > 0) {
                left = (int)((left + right) / 2 + 1);
            } else {
                right = (int)((left + right) / 2);
            }
        }

        return (int)((left + right) / 2);


    }

    int guess(int num) {
        return actual - num;
    }

    public static void main(String[] args) {
        Prob_374 prob = new Prob_374(6, 1);
//        AssertUtils.equals(prob.actual, prob.guessNumber(6));
//        prob = new Prob_374(10, 1);
//        AssertUtils.equals(prob.actual, prob.guessNumber(10));
//        prob = new Prob_374(10, 10);
//        AssertUtils.equals(prob.actual, prob.guessNumber(10));
//        prob = new Prob_374(10, 1);
//        AssertUtils.equals(prob.actual, prob.guessNumber(10));
//        prob = new Prob_374(1, 1);
//        AssertUtils.equals(prob.actual, prob.guessNumber(1));
        prob = new Prob_374(2126753390, 1702766719);
        AssertUtils.equals(prob.actual, prob.guessNumber(2126753390));
    }

}
