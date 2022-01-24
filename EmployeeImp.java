import java.util.HashMap;
import java.util.List;

// TC O(N)
// SC O(N)
public class EmployeeImp {
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };

    HashMap<Integer, Employee> map;
    int result;

    public int getImportance(List<Employee> employees, int id) {
        map = new HashMap<>();
        for (Employee emp : employees) {
            map.put(emp.id, emp);
        }
        return dfs(id);
        // return result;
    }

    private int dfs(Integer id) {
        Employee e = map.get(id);
        int result = 0;
        result += e.importance;
        for (int subId : e.subordinates) {
            result += dfs(subId);
        }
        return result;
    }
}
