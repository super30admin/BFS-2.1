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

        dfs(id);
        return total;
    }

    private void dfs(int id){
        Employee curr = map.get(id);
        total = total + curr.importance;
        for(int j : curr.subordinates){
            dfs(j);;
        }
    }
}

//O(n) time complexity and O(n) space compelexity