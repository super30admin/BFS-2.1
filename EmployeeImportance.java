import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;

    public Employee(int id, int importance, List<Integer> subordinates) {

        this.id = id;
        this.importance = importance;
        this.subordinates = subordinates;

    }
}

public class EmployeeImportance {

    public static void main(String[] args) {
        Employee employee1 = new Employee(1, 5, List.of(2, 3));
        Employee employee2 = new Employee(2, 3, List.of(1, 3));
        Employee employee3 = new Employee(3, 4, List.of(1, 1));
       
        List<Employee> employees = List.of(employee1, employee2, employee3);
        EmployeeImportance obj = new EmployeeImportance();
        int obj1 = obj.getImportance(employees, 2);
        System.out.println(obj1);

    }

    public int getImportance(List<Employee> Employees, int id) {

        HashMap<Integer, Employee> map = new HashMap<>();
        for (Employee e : Employees) {
            // EmployeeImportance eid = map.get(id);
            map.put(e.id, e);

        }

        Queue<Integer> q = new LinkedList<>();
        q.add(id);
        int result = 0;

        while (!q.isEmpty()) {
            int eid = q.poll();
            Employee e = map.get(eid);
            result += e.importance;
            for (int sub : e.subordinates) {
                q.add(sub);
            }

        }
        return result;

    }
}