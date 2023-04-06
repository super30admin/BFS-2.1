/*The time complexity of this implementation is O(n)
 * and space complexity is O(n)*/
import java.util.*;

class EmployeeImportance {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> employeeMap = new HashMap<>();
        for (Employee employee : employees) {
            employeeMap.put(employee.id, employee);
        }

        int importance = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(id);
        while (!queue.isEmpty()) {
            int currentId = queue.poll();
            Employee currentEmployee = employeeMap.get(currentId);
            importance += currentEmployee.importance;
            for (int subordinateId : currentEmployee.subordinates) {
                queue.offer(subordinateId);
            }
        }

        return importance;
    }
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, 5, Arrays.asList(2, 3)));
        employees.add(new Employee(2, 3, Collections.emptyList()));
        employees.add(new Employee(3, 3, Collections.emptyList()));
        int id = 1;
        EmployeeImportance solution = new EmployeeImportance();
        int importance = solution.getImportance(employees, id);
        System.out.println("Importance of employee with ID " + id + ": " + importance);
    }

}
