package Leecode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Prob_690 {
    static class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    }

    public int getImportance(List<Employee> employees, int id) {

        Map<Integer, Employee> idMap = new HashMap<>();

        for (Employee employee : employees) {
            idMap.put(employee.id, employee);
        }

        Employee root = idMap.get(id);

        Stack<Employee> stack = new Stack<>();

        int total = 0;

        stack.push(root);
        while (!stack.isEmpty()){
            Employee top = stack.pop();
            total += top.importance;

            if(top.subordinates != null) {
                top.subordinates.forEach(e -> stack.add(idMap.get(e)));
            }

        }

        return total;

    }
}
