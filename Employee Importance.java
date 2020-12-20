/*
class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        if employees is None or len(employees) == 0:
            return 0
        
        mapping = {}
        for i in range(len(employees)):
            mapping[employees[i].id] = employees[i]
        
        total = 0
        q = collections.deque()
        q.append(id)
        while len(q) > 0:
            size = len(q)
            for i in range(size):
                e_id = q.popleft()
                e = mapping[e_id]
                total += e.importance
                
                for j in range(len(e.subordinates)):
                    q.append(e.subordinates[j])
        
        return total


class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        if employees is None or len(employees) == 0:
            return 0
        
        mapping = {}
        for i in range(len(employees)):
            mapping[employees[i].id] = employees[i]
        
        total = 0
        q = collections.deque()
        q.append(id)
        while len(q) > 0:
            e_id = q.popleft()
            e = mapping[e_id]
            total += e.importance

            for j in range(len(e.subordinates)):
                q.append(e.subordinates[j])
        
        return total


class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        if employees is None or len(employees) == 0:
            return 0
        
        self.mapping = {}
        for i in range(len(employees)):
            self.mapping[employees[i].id] = employees[i]
        
        self.total = 0
        self.dfs(id)
        return self.total
    
    def dfs(self, id):
        e = self.mapping[id]
        self.total += e.importance
        
        for i in e.subordinates:
            self.dfs(i)
*/

/*
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        if (employees == null || employees.size() == 0)
            return 0;
        
        HashMap<Integer, Employee> map = new HashMap<>();
        int total = 0;
        
        for (Employee e: employees){
            map.put(e.id, e);
        }
        
        Queue<Integer> q = new LinkedList<>();
        q.add(id);
        while (!q.isEmpty()){
            int frontid = q.poll();
            Employee e = map.get(frontid);
            total += e.importance;
            for (int sub: e.subordinates){
                q.add(sub);
            }
        }

        return total;
    }
}
*/

// Time Complexity : O(n) where n is no of employees
// Space Complexity : O(h) where h is height of employee tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: I started with maintaining hashmap of all employees and then did dfs
// on the given id and added all the importance of its subordinates

class Solution {
    HashMap<Integer, Employee> map;
    int total;
    public int getImportance(List<Employee> employees, int id) {
        if (employees == null || employees.size() == 0)
            return 0;
        
        map = new HashMap<>();
        total = 0;
        
       for (Employee e: employees){
           map.put(e.id, e);
       }
       dfs(id);
        return total;
    }
    
    private void dfs(int id){
        Employee e = map.get(id);
        total += e.importance;
        
        for (int sub: e.subordinates)
            dfs(sub);
    }
    
}