// Time Complexity : o(n)
// Space Complexity : o(n+h) h is recursion stack height of tree if dfs is used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    HashMap<Integer,Employee> map;
    public int getImportance(List<Employee> employees, int id) {
        
        if (employees == null)
            return -1;
        map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        return dfs(id);
        
    }
    
    private int dfs(int id)
    {
        Employee e=map.get(id);
        
             int result=e.importance;
        
         for(int sub:e.subordinates)
         {
             result+=dfs(sub);
         }
        return result;
    }
    
    private int bfs(int id)
    {
        Queue<Integer> queue=new LinkedList<>();
        
        queue.add(id);
        
        int result=0
        while(!queue.isEmpty())
        {
            int employeeId=queue.poll();
            Employee e=map.get(employeeId);
            result+=e.importance;
            //adding subordinates to queue
            for(int subord:e.subordinates)
            {
                queue.add(subord);
            }
        }
        return result;
    }
}