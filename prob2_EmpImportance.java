

// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


class Solution {
    HashMap<Integer, Employee> map;
    int totalImp;
    public int getImportance(List<Employee> employees, int id) {
        map = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        
        for(Employee emp : employees){
            map.put(emp.id, emp); //Storing emp id to employee object in hashmap
        }
        //DFS
        dfs(id);
        return totalImp;
    }
    public void dfs(int id){
        Employee emp = map.get(id); // Fetching employee object using id from map
        totalImp += emp.importance; 
        
        for(int i : emp.subordinates){  // For all ids in subordinates , calling recursive function for calculating importance  
            dfs(i);
        }
    }
}

/*

class Solution {
    HashMap<Integer, Employee> map;
    public int getImportance(List<Employee> employees, int id) {
        map = new HashMap<>();
        
        Queue<Integer> queue = new LinkedList<>();
        
        for(Employee emp : employees){
            map.put(emp.id, emp);
        }
        
        queue.add(id);
        
        //BFS
        
        int totalImp = 0;
        
        while(!queue.isEmpty()){
            int currId = queue.poll();
            
            Employee e = map.get(currId);
            
            totalImp += e.importance;
            for(int i : e.subordinates){
                queue.add(i);
            }
        }
        
        return totalImp;
    }
}


*/

