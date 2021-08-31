/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public IList<int> subordinates;
}
*/
//Time Complexity: O(n)
//Space Complexity: O(n)
class Solution {
    public int GetImportance(IList<Employee> employees, int id) {
         if (employees == null || employees.Count == 0)
            {
                return 0;
            }
            Dictionary<int, Employee> map = new Dictionary<int, Employee>();
            foreach (Employee emp in employees)
            {
                map.Add(emp.id, emp);
            }
            //BFS
            Queue<int> q = new Queue<int>();
            int total = 0;
            q.Enqueue(id);
            while (q.Count != 0)
            {
                int curr = q.Dequeue();
                Employee e = map[curr];
                total += e.importance;
                IList<int> subs = e.subordinates;
                if (subs != null)
                {
                    foreach (int sub in subs)
                    {
                        q.Enqueue(sub);
                    }
                }
            }
            return total;
    }
}