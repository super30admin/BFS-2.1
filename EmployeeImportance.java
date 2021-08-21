//https://leetcode.com/problems/employee-importance/
/*
Time: O(N) where N = number of employees
Space: O(N)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/
public class EmployeeImportance {

    public int getImportance(List<Employee> employees, int id) {

        Map<Integer, Employee> map = new HashMap();

        for (Employee employee : employees)
            map.put(employee.id, employee);

        Queue<Employee> q = new LinkedList();
        q.add(map.get(id)); // add the employee object to the q. If id=3, add 3 alone to the q.
        int importance = 0;

        while (!q.isEmpty()) {
            Employee emp = q.poll();
            importance += emp.importance;

            // add direct subordinates in q
            for (int subId : emp.subordinates) // this automatically adds it's recursive subordinates as well
                q.add(map.get(subId));
        }

        return importance;
    }

}
