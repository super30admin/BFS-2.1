// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

//BFS Approach
//O(n), O(n)
  Dictionary<int, Employee> dict;
    int total = 0;
    
    public int GetImportance(IList<Employee> employees, int id) {
        if(employees == null || employees.Count == 0)
            return 0;
        dict = new Dictionary<int, Employee>();
        foreach(var employee in employees)
        {
            dict.Add(employee.id, employee);
        }
        
        //queue will be of type int, because ID at every point is root
        Queue<int> queue = new Queue<int>();
        queue.Enqueue(id);
        
        while(queue.Count > 0)
        {
            int curr = queue.Dequeue();
            var emp = dict[curr];
            total += emp.importance;
            foreach(int sub in emp.subordinates)
            {
                queue.Enqueue(sub);
            }
        }
        return total;
    }

//DFS approach
//O(n), O(h)

 Dictionary<int, Employee> dict;
    int total = 0;
    
    public int GetImportance(IList<Employee> employees, int id) {
        if(employees == null || employees.Count == 0)
            return 0;
        dict = new Dictionary<int, Employee>();
        foreach(var employee in employees)
        {
            dict.Add(employee.id, employee);
        }
        dfs(id);
        return total;
    }
    
    private void dfs(int id)
    {
        //base
        var emp = dict[id];
        total += emp.importance;
        
        foreach(int sub in emp.subordinates)
        {
            dfs(sub);
        }
    }
 