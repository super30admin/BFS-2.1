"""
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""
from collections import deque
class Solution:
    """DFS Implementation
    Time complexity-O(n)
    Space Complexity-O(n)"""
    def __init__(self):
        self.result=0
        self.mapfunc={}
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        if not employees:
            return 0
        for i in employees:
            self.mapfunc[i.id]=i
        self.dfs(id)
        return self.result
    
    def dfs(self, i):
        if not i in self.mapfunc:
            return 0
        self.result+=self.mapfunc[i].importance
        children=self.mapfunc[i].subordinates
        if children:
            for j in children:
                self.dfs(j)
        
            
    """BFS Implementation
    Time complexity-O(n)i.e. V+E
    Space Complexity-O(n)"""
    # def getImportance(self, employees: List['Employee'], id: int) -> int:
    #     result=0
    #     q=deque()
    #     mapfunc={}
    #     for i in employees:
    #         mapfunc[i.id]=i
    #     for i in mapfunc:
    #         if i==id:
    #             q.append(i)
    #     while q:
    #         size=len(q)
    #         for i in range(size):
    #             curr=q.popleft()
    #             result+=mapfunc[curr].importance
    #             children=mapfunc[curr].subordinates
    #             if children:
    #                 for j in children:
    #                     q.append(j)
    #     return result
                    
            
        