
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Scanner;

public class EmployeeImportanceDFS {

    public static class Employee {

        int id;
        int importance;
        public List<Integer> subordinates;
    }

    //DFS - Recursion

    public int getImportance(List<Employee> employees, int id) {

        //map employee id(attribute) to employee object
        HashMap<Integer, Employee> map = new HashMap<>();

        // for each employee object running over a list in for loop
        for(Employee e: employees) {

            //make map
            map.put(e.id, e);
        }
        //run dfs
        return dfs(map, id);
    }
    int impTotal;
    private int dfs(HashMap<Integer, Employee> map, int id) {

        // add current importance
        impTotal = map.get(id).importance;

        // run over subordinates recursively in dfs way
        for(int sub: map.get(id).subordinates) {

            //increment importance
            impTotal += dfs(map, sub);
        }
        // output total importance
        return impTotal;
    }

    public static void main(String[] args) {

        EmployeeImportanceDFS object = new EmployeeImportanceDFS();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the total number of employees: ");
        int numEmployees = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character after reading the number

        List<EmployeeImportanceDFS.Employee> employList = new ArrayList<>();

        for (int i = 0; i < numEmployees; i++) {
            System.out.println("Enter details for employee " + (i + 1) + ":");

            System.out.print("Enter employee ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character after reading the number

            System.out.print("Enter employee importance: ");
            int importance = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character after reading the number

            System.out.print("Enter the number of subordinates: ");
            int numSubordinates = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character after reading the number

            List<Integer> subordinates = new ArrayList<>();

            for (int j = 0; j < numSubordinates; j++) {
                System.out.print("Enter subordinate ID " + (j + 1) + ": ");
                int subordinateId = scanner.nextInt();
                subordinates.add(subordinateId);
            }

            EmployeeImportanceDFS.Employee employee = new EmployeeImportanceDFS.Employee();
            employee.id = id;
            employee.importance = importance;
            employee.subordinates = subordinates;

            employList.add(employee);
        }

        System.out.print("Enter the given employee ID: ");
        int desiredId = scanner.nextInt();

        // Call the method with the list of employees and desired ID
        int result = object.getImportance(employList, desiredId);
        System.out.println("Result: " + result);

    }





}

/*
TIME COMPLEXITY = O(N)

N - number of employees
if top most employee id is given, we run over each employee - worst case

SPACE COMPLEXITY = O(N)
recursive stack space

*/