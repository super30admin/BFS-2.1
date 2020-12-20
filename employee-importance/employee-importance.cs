/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public IList<int> subordinates;
}
*/
​
class Solution {
    public Dictionary<int ,Employee> emp = new Dictionary<int,Employee>();
    public int GetImportance(IList<Employee> employees, int id) {
        int totalimportance=0;
        
        foreach(Employee e in employees)
        {
            emp.Add(e.id,e);
        }
        
        return dfs(id);
        
        
        
    }
    
    public int dfs(int eid)
    {
        Employee e = emp[eid];
        int impcount = e.importance;
        foreach(int id in e.subordinates)
        {
            impcount+= dfs(id);
        }
        
        
        return impcount;
    
}
}
