import java.util.*;

public class EmployeeImportanceBFS {

    //BFS - Queue, HashMap - auxiliary DS

    public static class Employee {

        int id;
        int importance;
        public List<Integer> subordinates;
    }
    public int getImportance(List<Employee> employees, int id) {

        //map employee id(attribute) to employee object
        HashMap<Integer, Employee> map = new HashMap<>();

        if(employees == null) return 0;

        // for each employee object running over a list in for loop
        for(Employee e: employees) {

            //make map
            map.put(e.id, e);
        }

        //
        Queue<Integer> q = new LinkedList<>();

        int totalImp = 0;

        //pass given id to queue
        q.add(id);

        //BFS until queue gets empty
        while(!q.isEmpty()) {

            // pop out id
            int eid = q.poll();

            // get importance of employee with popped id
            Employee e = map.get(eid);

            //increment importance
            totalImp += e.importance;

            // for each subordinate of popped employee running over a list in for loop
            for(int subId: e.subordinates) {

                // add each subordinate id to queue to add its importance to result
                q.add(subId);
            }
        }
        // output after BFS
        return totalImp;
    }

    public static void main(String[] args) {

        EmployeeImportanceBFS object = new EmployeeImportanceBFS();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the total number of employees: ");
        int numEmployees = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character after reading the number

        List<Employee> employeesList = new ArrayList<>();

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

            Employee employee = new Employee();
            employee.id = id;
            employee.importance = importance;
            employee.subordinates = subordinates;

            employeesList.add(employee);
        }

        System.out.print("Enter the given employee ID: ");
        int desiredId = scanner.nextInt();

        // Call the method with the list of employees and desired ID
        int result = object.getImportance(employeesList, desiredId);
        System.out.println("Result: " + result);

    }




}

/*
TIME COMPLEXITY = O(N)

N - number of employees
if top most employee id is given, we run over each employee - worst case

SPACE COMPLEXITY = O(N)

maximum queue size = N-1 when a single employee has all subordinates
*/
