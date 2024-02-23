/*
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(n)
    n = total employees
* 
* Space Complexity: O(n)
* 
*/

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};

public class EmployeeImportance {
    // HashMap<Integer, Employee> hmap;

    // private int dfs(int id) {
    //     Employee curr = hmap.get(id);

    //     int subordinatesImportance = 0;

    //     for (int subId : curr.subordinates) {
    //         subordinatesImportance += dfs(subId);
    //     }

    //     return curr.importance + subordinatesImportance;
    // }

    public int getImportance(List<Employee> employees, int id) {
        // this.hmap = new HashMap<>();

        // for (Employee emp : employees) {
        //     hmap.put(emp.id, emp);
        // }

        // return dfs(id);
        
        Queue<Integer> queue = new LinkedList<>();

        HashMap<Integer, Employee> hmap = new HashMap<>();

        for(Employee emp: employees){
            hmap.put(emp.id, emp);
        }

        queue.add(id);

        int empImportance = 0;

        while(!queue.isEmpty()){
            int currId = queue.poll();

            Employee curr = hmap.get(currId);
            
            empImportance += curr.importance;

            for(int subordinateId: curr.subordinates)
                queue.add(subordinateId);
        }

        return empImportance;
    }
}
