import java.util.*;
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
public class EmployeeImportance {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer,Employee> map = new HashMap();
        for(Employee e:employees){
            map.put(e.id,e);
        }
        Queue<Employee> q = new LinkedList();
        int imp=0;
        q.add(map.get(id));
        while(!q.isEmpty()){
            Employee curr = q.poll();
            imp+=curr.importance;
            for(Integer sub:curr.subordinates){
                q.add(map.get(sub));
            }
        }
        return imp;
    }
}
