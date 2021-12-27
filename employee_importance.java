class Solution{
    HashMap<Integer, Employee> map;
    int total;
    public int getImportance(List<Employee> employees, int id){
        if(employees == null || employees.size() == 0) return 0;
        map = new HashMap<>();
        for(Employee emp: employees){
            map.put(emp.id, emp);
        }
        dfs(id);
        return total;
    }
    private void dfs(int id){
        //base

        //logic
        Employee obj = map.get(id);
        total += obj.improtance;
        for(int sub: obj.subordinates){
            dfs(sub);
        }
    }
}