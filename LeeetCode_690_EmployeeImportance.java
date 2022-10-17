/*Approach - 
1. create adjacency list - hashmap and add key as ids and objects as values
2. add the id given to the queue.
3. poll the ids from the queue. 
4. get the corresponding Object-value from the key=id polled from the Map.
5. store tht  object temporary and fetch the importance and add it to exisiting one. 
6. traverse over the subordiates and then add their ids to the queue. 
and repeat from step 3. 

//tc - O(v+E) = creating adjacency list and traversing throuhg it= n objects in list
//here vertices == edges cause all subordinates connected let say then v nodes and e edges where V is almost = E = O(v+E) = 2O(v)
//sc -O(V+E) = O(V)+ O(V) =  2O(v) = O(v) -- map + queue
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