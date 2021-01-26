/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/
/*
time complexity : O(n)
space complexity : O(n)
as in worst case we may end up searching all employees
*/
class Employee {
    HashMap<Integer,Employee> map;
    int ans; 
    public int getImportance(List<Employee> employees, int id) {
        
        this.map = new HashMap<>();
        for(Employee e : employees)
        {
            if(!map.containsKey(e.id)){
                map.put(e.id,e);
            }
           
        }
        
        //go find id in map
        dfs(id);  
        return ans;
    }
    
    private void dfs(int id){
        if(map.get(id) == null)
        {
            return;
        }
        
        Employee e = map.get(id);
        ans += e.importance;
        for(int subid : e.subordinates){
            dfs(subid);
        }
    }
}