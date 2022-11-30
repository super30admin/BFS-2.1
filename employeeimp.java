/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/
//tc: O(n)
//sc: O(height)
class Solution {
    HashMap<Integer, Employee> map;
    int totalImp;

    public int getImportance(List<Employee> employees, int id) {
        if(employees == null || employees.size() == 0) return 0;

        map = new HashMap<>();
        for(Employee emp : employees){
            map.put(emp.id, emp);
        }
        dfs(id);
        return totalImp;
    }

    private void dfs(int id){
        Employee emp = map.get(id);
        totalImp += emp.importance;
        List<Integer> subordinates = emp.subordinates;
        if(subordinates != null){
            for(int sub: subordinates){
                dfs(sub);
            }
        }
    }
}
