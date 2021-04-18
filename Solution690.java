/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution690 {
    int total;
        HashMap<Integer, Employee> map;
    public int getImportance(List<Employee> employees, int id) {
     total=0;
        map=new HashMap<>();
        for(Employee emp:employees){
            map.put(emp.id,emp);
        }
        dfs(id);
        return total;        
    }
    
    private void dfs(int id){
        Employee obj= map.get(id);
        total+=obj.importance;
        for(int subo: obj.subordinates){
            dfs(subo);
        }
        
    }
}