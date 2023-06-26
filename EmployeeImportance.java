import java.util.HashMap;
import java.util.List;

public class EmployeeImportance {
    private HashMap<Integer, Employee> employeeMapping;
    int total=0;
    public int getImportance(List<Employee> employees, int id) {
        this.employeeMapping=new HashMap<>();
        for(Employee e : employees){
            employeeMapping.put(e.id,e);
        }
        dfs(id);
        return total;
    }
    private void dfs(int id){
        Employee e=employeeMapping.get(id);
        total+=e.importance;
        for(int subId: e.subordinates){
            dfs(subId);
        }
    }
}
