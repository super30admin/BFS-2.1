# Time : O(V + E)
# Space: O(V + E)

from collections import deque
class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        
        if not employees or len(employees) == 0:
            return 0

        self.total = 0
        self.hashmap = {}

        for employee in employees:
            self.hashmap[employee.id] = employee

    
        self.dfs(id)
        return self.total

    
    def dfs(self, id):

        employee = self.hashmap[id]
        self.total += employee.importance

        for sub in employee.subordinates:
            self.dfs(sub)



# BFS Solution
# Time: O(V + E)
# Space: O(V+ E)

def getImportance(self, employees: List['Employee'], id: int) -> int:
        
    if not employees or len(employees) == 0:
        return 0

    result = 0
    hashmap = {}
    
    for emp in employees: # O(V + E)
        hashmap[emp.id] = emp
    
    q = deque()
    q.append(id)
    
    while q:
        
        current_id = q.popleft()
        emp = hashmap[current_id]
        result += emp.importance
        
        for sub in emp.subordinates:
            q.append(sub)
            
    return result