/*Approach - 
1. create adjacency list - hashmap and add key as ids and objects as values
2. call dfs(id).
//dfs logic
3. logic - get the map value for id. 
4. add importance
5. traverse through the list and do dfs on list values.  
//base case for dfs - if we find id ==0 return.

//tc - O(v+E) = creating adjacency list and traversing throuhg it= n objects in list
//here vertices == edges cause all subordinates connected let say then v nodes and e edges where V is almost = E = O(v+E) = 2O(v)
//sc -O(V+E) = O(V)+ O(V) =  2O(v) = O(v) -- map + internal recursive stack
*/

/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        
        if(id == 0 || employees == null) return 0;
        
        int importance =0;
        
        Map<Integer, Employee> map = new HashMap<>();
        
        //put all the list objects to the hashmap
        for(Employee employee : employees)
        {
            map.put(employee.id, employee);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(id);
        
        //bfs on the given id to calculate the total importance
        while(!q.isEmpty())
        {
            int idx = q.poll();
            Employee e = map.get(idx);
            
            //add importance
            importance += e.importance;
            //add subordinate from the list to queue. 
            List<Integer> list = e.subordinates;
            //check if list is null
            if(e.subordinates != null)
            {
                for(int sub : list)
                {
                    q.add(sub);
                }
            }
        }
        return importance;
        
    }
}