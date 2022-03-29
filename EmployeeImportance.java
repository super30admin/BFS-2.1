//Time Complexity O(n)
//Space Complexity O(n/2)
//Leetcode tested

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
    public int getImportance(List<Employee> employees, int id) {
        int totalImportance=0;
        HashMap<Integer,Employee> hm = new HashMap<>();
        Queue<Employee> q  = new LinkedList<>();
        for (int i = 0; i < employees.size(); i++) {
            hm.put(employees.get(i).id,employees.get(i));
        }
        q.add(hm.get(id));
        totalImportance = totalImportance + (hm.get(id).importance);
        while (!q.isEmpty()){
            Employee current = q.poll();
            for (int i = 0; i < current.subordinates.size(); i++) {
                Employee subordinate = hm.get(current.subordinates.get(i));
                totalImportance = totalImportance + subordinate.importance;
                q.add(subordinate);
            }
        }
        return totalImportance;
    }
}
