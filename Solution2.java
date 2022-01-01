//BFS
// Time Complexity :O(V+E)traverse over the employeee and its subsequent adjacency list E, V being the number of employees, E being list of subordinates, cannot go beyond O(V)
// Space Complexity :O(V) maximum elements in queue
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :
class Solution2 {
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
// Time Complexity :O(V+E)traverse over the employeee and its subsequent adjacency list E, V being the number of employees, E being list of subordinates, cannot go beyond O(V)
// Space Complexity :O(V) maximum elements in map +recursive stack space
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