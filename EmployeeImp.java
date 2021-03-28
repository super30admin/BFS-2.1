import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
// Time Complexity : O(n); n = #emp
// Space Complexity : O(2n) = O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
public class EmployeeImp {
    public int getImportance(List<Employee> employees, int id) {
        if(employees == null || employees.size() == 0) return 0;

        Queue<Integer> queue = new LinkedList<>();
        HashMap<Integer, Employee> map = new HashMap<>();

        for (Employee emp : employees) {
            map.put(emp.id, emp);
        }

        queue.offer(id);

        int total = 0;

        while (!queue.isEmpty()) {
            int i = queue.poll();
            total += map.get(i).importance;
            List<Integer> sub = map.get(i).subordinates;
            if (sub.size() != 0) {
                for (int s : sub)
                    queue.offer(s);
            }

        }
        return total;
    }
}
