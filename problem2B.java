import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
}

class employeeImportaance{
    HashMap<Integer, Employee> map;
    int total = 0;
    public int getImportance(List<Employee> employees, int id) {
        if(employees == null || employees.size() == 0) return 0;

        map = new HashMap<>();
        for(Employee e : employees){
            map.put(e.id, e);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(id);

        while(!q.isEmpty()){
            int emp = q.poll();
            Employee curr = map.get(emp);
            total = total + curr.importance;
            for(int j : curr.subordinates){
                q.add(j);
            }
        }
        return total;
    }
}

//O(n) time complexity and O(n) space compelexity