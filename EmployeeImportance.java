import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Leetcode - 690
//TC - O(N) , N - total no of employees
//SC - O(N)
public class EmployeeImportance {
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };
    //BFS
    public int getImportance(List<Employee> employees, int id) {
        Queue<Integer> q = new LinkedList<>();
        HashMap<Integer, Employee> map = new HashMap<>(); // map of employeeIds and that EmployeeObj
        for(Employee e : employees) {
            map.put(e.id, e);
        }
        q.add(id);
        int result =0;
        while(!q.isEmpty()) {
            int eid = q.poll();
            Employee e = map.get(eid);
            result = result + e.importance;
            for(int subId : e.subordinates) {
                q.add(subId);
            }
        }
        return result;
    }
}
