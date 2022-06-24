"""
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""
# Time Complexity: O(n)
# Space Complexity: O(n)
# BFS
class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        from collections import deque
        q=deque()
        q.append(id)
        hmap={}
        for e in employees:
            hmap[e.id]=e
        imp=0
        while len(q)!=0:
            cur=q.popleft()
            emp=hmap[cur]
            imp+=emp.importance
            for e in emp.subordinates:
                q.append(e)
        return imp
# DFS
# Time Complexity: O(n)
# Space Complexity: O(n)
    # def getImportance(self, employees: List['Employee'], id: int) -> int:
    #     self.hmap={}
    #     for e in employees:
    #         self.hmap[e.id]=e
    #     self.imp=0
    #     self.dfs(id)
    #     return self.imp
    # def dfs(self,id:int):
    #     self.imp+=self.hmap[id].importance        
    #     for i in self.hmap[id].subordinates:
    #         self.dfs(i)
         
        
        
        
            
        