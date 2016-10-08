package algo.warmup;


import java.util.*;

/**
 * Created by kenvi on 16/10/8.
 */
public class MaximumPerimeterTriangle {

    static class Triangle implements Comparable<Triangle> {
        private List<Long> sideList = new ArrayList<>(3);

        public Triangle(long a, long b, long c) {
            sideList.add(a);
            sideList.add(b);
            sideList.add(c);
            Collections.sort(sideList);
        }

        public long getMaximum() {
            return sideList.get(2);
        }

        public long getMinimum(){
            return sideList.get(0);
        }




        @Override
        public int compareTo(Triangle o) {
            if(o.getMaximum() != this.getMaximum()) {
                return (int)(o.getMaximum() - this.getMaximum());
            }else {
                return (int)(o.getMinimum() - this.getMinimum());
            }
        }

        public void printTriangle(){
            System.out.println(sideList.get(0) + " " + sideList.get(1) +" " + sideList.get(2));
        }
    }

    static boolean formTriangle(long a, long b, long c) {
        return (a+b > c) && (a+c > b) && (b+c>a);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> stickList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            stickList.add(scanner.nextInt());
        }
        long maxP = -1;
        List<Triangle> triangleList = new ArrayList<>();
        for (int i_1 = 0; i_1 < n -2; i_1++) {
            for (int i_2 = i_1+1; i_2 < n-1; i_2++) {
                for (int i_3 = i_2+1; i_3 < n; i_3++) {
                   long a = stickList.get(i_1);
                    long b = stickList.get(i_2);
                    long c = stickList.get(i_3);
                   if(formTriangle(a,b,c)) {
                       long p = a + b + c;
                       if(p > maxP) {
                           maxP = p;
                           triangleList.clear();
                           triangleList.add(new Triangle(a,b,c));
                       }else if(p == maxP) {
                           triangleList.add(new Triangle(a,b,c));
                       }
                   }
                }
            }
        }

        Collections.sort(triangleList);
        if(triangleList.size() ==0 ){
            System.out.println(-1);
        }else{
            triangleList.get(0).printTriangle();
        }

    }
}
