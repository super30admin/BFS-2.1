/**
Time Complexity : O(N)
Space Complexity : O(N)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : Yes

**/
class Solution 
{
    public int getImportance(List<Employee> employees, int id) 
    {
        Map<Integer, Employee>  map = new HashMap<>();

        for(Employee employee: employees)
            map.put(employee.id, employee);
        
        int totalValue = 0;
        
        Queue<Employee> queue = new LinkedList<>();
        Employee emp = map.get(id);
        
        queue.add(emp);
        
        while(!queue.isEmpty())
        {
            int size = queue.size();
            
            for(int i = 0; i < size; i++)
            {
                Employee current = queue.poll();
                List<Integer> subordinates = map.get(current.id).subordinates;
                
                if(subordinates != null && subordinates.size() > 0)
                {
                    for(int sub: subordinates)
                        queue.add(map.get(sub));
                        
                }
                
                totalValue = totalValue + current.importance;
            }
        }
        
        return totalValue;
        
    }
}