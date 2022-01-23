import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


// TC O(n)
// SC O(n)
public class GetImportance {
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer,Employee> map = new HashMap<>();
        for (Employee employee :employees) {
            map.putIfAbsent(employee.id,employee);
        }
        int result = 0;
        Queue<Employee> queue = new LinkedList<>();
        queue.add(map.get(id));
        while (!queue.isEmpty()){
            Employee employee = queue.poll();
            result+=employee.importance;
            for (int subordinate :employee.subordinates) {
                queue.add(map.get(subordinate));
            }
        }
        return result;
    }
}
