// Time Complexity : O(n)
// Space Complexity : O(n) - eMap of all employees
// Did this code successfully run on Leetcode : Yes

import java.util.*;

public class Employee_Importance {

    static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;

        public Employee(int id, int importance, List<Integer> subordinates) {
            this.id = id;
            this.importance = importance;
            this.subordinates = subordinates;
        }
    };

    public static int getImportance(List<Employee> employees, int id) {
        Queue<Integer> q = new LinkedList<>();
        Map<Integer, Employee> eMap = new HashMap<>();

        for(Employee e : employees){
            eMap.put(e.id, e);
        }

        q.add(id);
        int result = 0;
        while(!q.isEmpty()){
            //fetch from queue
            int eid = q.poll();
            //get emp record
            Employee e = eMap.get(eid);
            result += e.importance;
            for(int subEid : e.subordinates){
                q.add(subEid);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        Employee e1 = new Employee(1,2, Arrays.asList(5));
        Employee e5 = new Employee(5,-3, Arrays.asList());

        employees.add(e1);
        employees.add(e5);
        System.out.println("Total Importance : " + getImportance(employees,5));
    }


}
