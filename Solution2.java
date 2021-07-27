// Time complexity: O(e), where e is the number of employees
// Space complexity: O(e)

import java.util.*;

class Solution {
    class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};

    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> map = new HashMap<>(); 
        for(Employee e: employees) {
            map.put(e.id, e); 
        }
        
        int importance = 0;
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(id);
        while(!q.isEmpty()) {
            int e = q.poll(); 
            importance += map.get(e).importance;
            for(int so: map.get(e).subordinates) {
                q.offer(so); 
            }
        }

        return importance; 
    }
}