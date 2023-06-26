import java.util.HashMap;
import java.util.List;

// Definition for Employee.
class Employee {
    int id;
    int importance;
    int[] subordinates;
}


class EmployeeImportance {
    private HashMap<Integer, Employee> map;
    int total;

    public int getImportance(List<Employee> employees, int id) {

        this.map = new HashMap<>();
        for(Employee e: employees){
            if(!map.containsKey(e.id)){
                map.put(e.id, e);
            }
        }
        dfs(id);
        return total;
    }

    private void dfs(int id){
        Employee current = map.get(id);
        total = total + current.importance;
        if(current.subordinates == null || current.subordinates.size() == 0) return;
        for(int i=0; i< current.subordinates.size(); i++){
            dfs(current.subordinates.get(i));
        }
    }

}