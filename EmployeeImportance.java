/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/
// time complexity 0(n)
// space complexity 0(n )

class Solution {
    HashMap<Integer,Employee> map = new HashMap<>();
    int totalImportance=0;
    public int getImportance(List<Employee> employees, int id) {
        if(employees == null || employees.size()==0)
        {
            return 0;
        }
        for(Employee e:employees)
        {
            map.put(e.id,e);
        }
        dfs(id);

        return totalImportance;
    }
    private void dfs(int id)
    {
        Employee emp=map.get(id);
        if(emp!=null)
        {
            totalImportance+=emp.importance;
            for(int sub: emp.subordinates)
            {
                dfs(sub);
            }
        }
    }
}