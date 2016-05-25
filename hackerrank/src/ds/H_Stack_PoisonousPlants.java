import java.util.Scanner;
import java.util.Stack;

/**
 * Created by kenvi on 16/5/9.
 */
public class H_Stack_PoisonousPlants {

    static class Plant{
        int pesticide;
        boolean isDead;
    }
    //TODO fix time out
    public static void main(String[] args) {
        int days = 0;

        Stack<Plant> pesticideStack = new Stack<Plant>();
        Stack<Plant> tmpStack = new Stack<Plant>();

        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        boolean dies = false;
        while( N --> 0) {
            int p = scanner.nextInt();
            Plant plant = new Plant();
            plant.isDead = false;
            plant.pesticide = p;
            if(!pesticideStack.isEmpty()) {
                Plant top = pesticideStack.peek();
                if(p <= top.pesticide) {
                    plant.isDead = false;
                }else {
                    plant.isDead = true;
                    dies = true;
                }
            }
            pesticideStack.push(plant);

        }

        if(!dies) {
            System.out.println(0);
            return;
        }
        days++;
        //


        do {
            dies= false;
            while(!pesticideStack.isEmpty()) {
                Plant top = pesticideStack.pop();
                if(!top.isDead) {
                    tmpStack.push(top);
                }
            }

            dumpStack(tmpStack);
            while(!tmpStack.isEmpty()) {
                Plant tmp = tmpStack.pop();
                if(!pesticideStack.isEmpty()) {
                    Plant top = pesticideStack.peek();
                    if(tmp.pesticide > top.pesticide) {
                        dies = true;
                        tmp.isDead = true;
                    }
                }

                pesticideStack.push(tmp);
            }
            if(dies)
               days++;
            dumpStack(pesticideStack);

        }while(dies);

        System.out.println(days);



    }

    static void dumpStack(Stack<Plant> stack){
        for(int i = 0; i < stack.size(); i++) {
            System.out.print(stack.get(i).pesticide + " " + stack.get(i).isDead + "|");
        }
        System.out.println();

    }
}
