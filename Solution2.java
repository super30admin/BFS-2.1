class Solution {
    // Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
    //BFS
    HashMap<Integer,Employee> map;
    int total;
    public int getImportance(List<Employee> employees, int id) {
        map=new HashMap<>();
        Queue<Employee> q= new LinkedList<>();
        for(Employee emp:employees){
            map.put(emp.id,emp);
            if(id==emp.id){
                q.add(emp);
            }
        }
        
        while(!q.isEmpty()){
            Employee emp=q.poll();
            total+=emp.importance;
            for(int sub:emp.subordinates){
                Employee subordinate=map.get(sub);
                q.add(subordinate);
            }
        }
        return total;
    }

    //DFS 
    HashMap<Integer,Employee> map1;
    int total1;
    public int getImportance1(List<Employee> employees, int id) {
        map=new HashMap<>();
        for(Employee emp:employees){
            map1.put(emp.id,emp);
        }
        
        for(Employee emp:employees)
    {
            if(id==emp.id){
                dfs(emp);
            }
    }

        return total1;
}
    private void dfs(Employee emp){
        
        //base
        if (emp==null)
            return;
        //logic
        total1+=emp.importance;
        for(int sub:emp.subordinates){
            Employee subordinate=map1.get(sub);
            System.out.println(subordinate.id);
            dfs(subordinate);
        }
    }
}