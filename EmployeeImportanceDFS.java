package BFS21;

import java.util.HashMap;
import java.util.List;

public class EmployeeImportanceDFS {
    HashMap<Integer, Employee> map;
    int total = 0;
    public int getImportance(List<Employee> employees, int id) {
        map = new HashMap<>();
        for(Employee emp : employees){
            map.put(emp.id, emp);
        }
        dfs(id);
        return total;
    }
    private void dfs(int id){
        total += map.get(id).importance;
        for(int eId : map.get(id).subordinates){
            dfs(eId);
        }
    }
}
