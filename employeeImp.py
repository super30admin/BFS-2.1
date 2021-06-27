# Time Complexity : O(N) 
# Space Complexity :    O(N)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO

"""
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""
#BFS
class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        if len(employees)==0:
            return 0
        
        hashmap = {} #key - id , value = employees obj
        for e in employees:
            hashmap[e.id] = e
            
        q = deque()
        #add id to the queue
        q.append(id)
        result = 0
        
        while(len(q)):
            eid = q.popleft()
            edetails = hashmap[eid]
            result+=edetails.importance
            for subid in edetails.subordinates:
                q.append(subid)
        
        return result
                
#DFS

class Solution:
    def __init__(self):
        self.importance = 0
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        if len(employees)==0:
            return 0
        hashmap = {} #key - id , value = employees obj
        for e in employees:
            hashmap[e.id] = e
            
        self.dfs(id,hashmap)
        return self.importance
    
    def dfs(self,id,hashmap):
        emp = hashmap[id]

        self.importance+=emp.importance

        for e in emp.subordinates:
            self.dfs(e,hashmap)
        


        


                        
                        
                    
        