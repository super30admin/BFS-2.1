import java.util.*;

/*
Time Complexity: O(N) N is the size of the Employees List
Space Complexity: O(N), N is the size of Queue
Run on leetcode: yes

Approach:
1. I am using Breadth First search to solve this problem,
2. Pushing employee details in the queue and processing it in the while loop to get the importance value
 */
public class EmployeeImportance {
    public static class Employee{
        int id;
        int importance;
        List<Integer> subordinates;
        Employee(int id, int importance, List<Integer> subordinates){
            this.id= id;
            this.importance = importance;
            this.subordinates = subordinates;
        }
    }

    public static HashMap<Integer, Employee> empMap;
    public static int getImportance(List<Employee> employees, int id){
        empMap = new HashMap<>();

        for(Employee emp: employees){
            empMap.put(emp.id, emp);
        }
        Queue<Employee> queue = new LinkedList<>();

        int totalImportance = 0;
        queue.add(empMap.get(id));

        while(!queue.isEmpty()){
            Employee employee = queue.remove();
            totalImportance+= employee.importance;

            for(int subordinate: employee.subordinates){
                queue.add(empMap.get(subordinate));
            }
        }
        return totalImportance;
    }

    public static void main(String[] args){
        List<Integer> sub1 = new ArrayList<>();
        sub1.add(2);
        sub1.add(3);
        List<Integer> sub2 = new ArrayList<>();
        List<Integer> sub3 = new ArrayList<>();
        Employee emp1 = new Employee(1, 5, sub1);
        Employee emp2 = new Employee(2, 3, sub2);
        Employee emp3 = new Employee(3, 3, sub3);
        List<Employee> employees = new ArrayList<>();
        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);

        System.out.print("Importance factor: "+ getImportance(employees,1));
    }
}
