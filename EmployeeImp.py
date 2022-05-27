#Time complexity: O(n)
#Space complexity: O(h)
"""
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""

class Solution:
    dict1={}
    imp=0
    def getImportance(self, employees, id: int) -> int:
        self.dict1={}
        self.imp=0
        for e in employees:
            self.dict1[e.id]=e
        self.dfs(id)
        return self.imp
        
    def dfs(self,root):
        if not root:
            return
        self.imp+= self.dict1[root].importance
        for sub in self.dict1[root].subordinates:
            self.dfs(sub)
        

        
        
        