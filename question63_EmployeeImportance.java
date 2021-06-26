package BFS2_1;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class question63_EmployeeImportance {
    /* Created by palak on 6/23/2021 */

    // Definition for Employee.
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }


    /*
        Time Complexity: O(n) // size of list
        Space Complexity: O(n)
    */

    int result;
    public int getImportance(List<Employee> employees, int id) {
        if(employees == null || employees.size() == 0) return 0;

        HashMap<Integer, Employee> map = new HashMap<>();
        int result = 0;

        for(Employee e: employees) {
            map.put(e.id, e);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(id);
        while(!queue.isEmpty()) {
            int eid = queue.poll();
            Employee e = map.get(eid);
            result += e.importance;

            for(int subId: e.subordinates) {
                queue.add(subId);
            }
        }
        return result;
    }
}
