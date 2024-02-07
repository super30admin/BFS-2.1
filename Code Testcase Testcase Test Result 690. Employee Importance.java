import java.util.Optional;
/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {

        Map<Integer, Employee> map = new HashMap<>();

        for(Employee e: employees) map.put(e.id, e);

        if(!map.containsKey(id)){
            return -1;
        }

        Queue<Employee> q = new LinkedList<>();
        q.offer(map.get(id));

        int gImportance = 0;

        while(!q.isEmpty()){
            Employee e = q.poll();
            gImportance += e.importance;
            e.subordinates.forEach(subId -> {
                q.offer(map.get(subId));
            });
        }

        return gImportance;
        
    }
}
