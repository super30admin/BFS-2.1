public class EmployeeImportance {
    public int getImportance(List<Employee> employees, int id) {
        if(employees == null || employees.size() == 0){
            return 0;
        }
        //map for id and Employee
        Map<Integer, Employee> map = new HashMap();
        for(Employee e: employees) map.put(e.id, e);
        return helper(map, id);
    }
    int helper(Map<Integer, Employee> map, int id){
        int res = map.get(id).importance;
        for(int s: map.get(id).subordinates){
            res += helper(map, s);
        }
        return res;
    }
}
