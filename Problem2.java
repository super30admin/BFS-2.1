import java.util.*;

public class Problem2 {
    // Definition for Employee.
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

    //BFS
    // TC : O(n)
    // SC : O(n)
    Map<Integer, Employee> map;

    public int getImportance(List<Employee> employees, int id) {
        map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        Queue que = new LinkedList<>();
        que.add(id);
        int total = 0;
        while (!que.isEmpty()) {
            Employee curr = map.get(que.poll());
            total = total + curr.importance;
            for (int subordinate : curr.subordinates) {
                que.add(subordinate);
            }
        }
        return total;
    }

    //DFS
    // TC : O(n)
    // SC : O(n)
    int total;
    public int getImportance1(List<Employee> employees, int id) {
        map = new HashMap<>();
        for (Employee e: employees){
            map.put (e.id, e);
        }

        helper(id);
        return total;
    }
    private void helper(int id){

        Employee junior = map.get(id);
        total = total + junior.importance;

        for (int subordinate : junior.subordinates){
            helper(subordinate);
        }
    }
}
