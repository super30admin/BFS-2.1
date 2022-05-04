import java.util.*;
public class EmployeeImportance {
    
    public static HashMap<Integer, Employee> map;
    public static int total;

    public static int getImportance(List<Employee> employees, int id)
    {
        map = new HashMap<>();

        if(employees == null || employees.size() == 0)
        {
            return 0;
        }

        for(Employee e: employees)
        {
            map.put(e.id,e);
        }

        dfs(id);

        return total;
    }

    public static void dfs(int id)
    {
        Employee emp = map.get(id);

        total = total + emp.importance;

        for(int juniors : emp.subordinates)
        {
            dfs(juniors);
        }
    }
}
