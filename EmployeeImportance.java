import java.util.*;

public class

    /*
    TC : O(N) where N is the number of employees
    SC : O(N)
    LC : Yes
    Poblems : No
     */

        /**
         * We perform BFS and create a map to store the employee id against its own data
         * The we use queue and add the given id to the queue. The we perform BFS of the queue and the add the importance everytime
         */
EmployeeImportance {

    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> map = new HashMap<>();
        for (Employee emp : employees)
            map.put(emp.id, emp);

        int ans = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(id);
        ans += map.get(id).importance;

        while (!q.isEmpty()) {

            List<Integer> subordinates = new ArrayList<>();
            int empid = q.poll();
            Employee temp = map.get(empid);
            subordinates = temp.subordinates;

            for (int sub : subordinates) {
                ans += map.get(sub).importance;
                q.add(sub);

            }
        }
        return ans;

    }
}
