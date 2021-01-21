#Time: O(n)
#Space: O(n) 
#leetcode: yes


"""
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""

class Solution:
    result=0
    hashmap={}
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        self.hashmap={}
        for e in employees:
            self.hashmap[e.id]=e
        self.dfs(id)
        return self.result
    def dfs(self,eid):
        emp=self.hashmap[eid]
        self.result+=emp.importance
        for sid in emp.subordinates:
            self.dfs(sid)
    
        
        