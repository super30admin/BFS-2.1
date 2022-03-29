
/**
 * Time complexity is O(n) - number of employees
 * space complexity is O(n) - for the hash map.
 */
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        
        for(Employee emp : employees) {
            map.put(emp.id, emp);
        }
        
        int result = 0;
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(id);
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int currId = queue.remove();
                Employee currEmp = map.get(currId);
                result = result + currEmp.importance;
                List<Integer> subs = currEmp.subordinates;
                for(int sub : subs) {
                    queue.add(sub);
                }
            }

        }
        
        return result;
        
    }
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }
}