"""
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""

from queue import Queue

class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        
        # DFS
        self.emSub = {}
        self.totalI = 0
        
        # Store the whole object as value cause it's a reference and not occupy space
        for emp in employees:
            em_id = emp.id
            self.emSub[em_id] = emp        
        
        def dfs(id):
            self.totalI += self.emSub[id].importance
            subs = self.emSub[id].subordinates
            for i in subs:
                dfs(i)

        dfs(id)
        return self.totalI
        
        
        # BFS
        emSub = {}
        totalImp = 0
        
        # Store the whole object as value cause it's a reference and not occupy space
        for emp in employees:
            em_id = emp.id
            emSub[em_id] = emp
            
            
        totalImp += emSub[id].importance
        q = Queue()
        q.put(emSub[id])
        
        while not q.empty():
            curr = q.get()
            
            for i in curr.subordinates:
                totalImp += emSub[i].importance
                q.put(emSub[i])
                
        return totalImp
