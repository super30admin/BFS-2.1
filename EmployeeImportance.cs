using System;
using System.Collections.Generic;

namespace Algorithms
{
    public class Employee
    {
        public int id;
        public int importance;
        public IList<int> subordinates;
    }

    /// Time Complexity :  V+E 
    // Space Complexity :O(N) 
    // Did this code successfully run on Leetcode :Yes
    // Any problem you faced while coding this :  No
    public class EmployeeImportance
    {
        Dictionary<int, Employee> map = new Dictionary<int, Employee>();
        public int GetImportance_BFS(IList<Employee> employees, int id)
        {
            if (employees == null) return 0;
            int result = 0;
            foreach (Employee e in employees)
            {
                map.Add(e.id, e);
            }
            Queue<int> q = new Queue<int>();
            q.Enqueue(id);
            while (q.Count != 0)
            {
                Employee curr = map.GetValueOrDefault(q.Dequeue());
                result += curr.importance;
                foreach (int e in curr.subordinates)
                {
                    q.Enqueue(e);
                }
            }
            return result;
        }



        /// Time Complexity : O(N) 
        // Space Complexity :O(N) 
        // Did this code successfully run on Leetcode :Yes
        // Any problem you faced while coding this :  No
        int result = 0;
        public int GetImportance_DFS(IList<Employee> employees, int id)
        {
            if (employees == null) return 0;

            foreach (Employee e in employees)
            {
                map.Add(e.id, e);
            }
            dfs(id);
            return result;
        }
        private void dfs(int id)
        {
            //base
            if (map == null) return;
            //logic
            Employee curr = map.GetValueOrDefault(id);
            result += curr.importance;
            foreach (int subId in curr.subordinates)
            {
                dfs(subId);
            }
        }
    }
}
