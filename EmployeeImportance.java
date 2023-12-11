import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeImportance {
    int out=0;
    Map<Integer,Employee > map = new HashMap<Integer,Employee>();
    public int getImportance(List<Employee> employees, int id) {

      for(Employee e : employees){
        map.put(e.id, e);
      }
      helper(map.get(id));
      return out;
    }

    private void helper(Employee e){

      out=out+e.importance;
      for(Integer s : e.subordinates){
        helper(map.get(s));
      }
    }
  }