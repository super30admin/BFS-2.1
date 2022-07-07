import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// TIme complexity: O(N) where N is the number of employees
// SPace complexity: O(N) where N is the number of employees

public class EmployeeIMportance {
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };
    HashMap<Integer, Employee> map;
    public int getImportance(List<Employee> employees, int id) {
        map = new HashMap<>();
        for(Employee e: employees){
            map.put(e.id, e);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(id);
        int result = 0;
        while(!q.isEmpty()){
            int eid = q.poll();
            Employee emp = map.get(eid);
            result+=emp.importance;
            for(int subId: emp.subordinates){
                q.add(subId);
            }
        }
        return result;
    }

}
