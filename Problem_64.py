"""
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""
########## DFS Solution, Time: O(V+E), Space: O(V+E) but here it is sinly one edge per node to its parent and one to its child so in this scenario its comparable to O(n) ##############
# class Solution:
#     def __init__(self):
#         self.h = {}
#         self.result = 0
        
#     def dfs(self,id):
#         self.result += self.h[id].importance
#         for sub in self.h[id].subordinates:
#             self.dfs(sub)
    
#     def getImportance(self, employees: List['Employee'], id: int) -> int:
#         for i in employees:
#             self.h[i.id] = i
#         self.dfs(id)
        
#         return self.result

############# BFS Solution O(V+E) time and space which is comparable to O(n) in this case ################
class Solution:
    def __init__(self):
        self.h = {}
        self.result = 0
    
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        for i in employees:
            self.h[i.id] = i
        
        q = collections.deque()
        q.appendleft(id)
        
        while q:
            curr = q.pop()
            self.result += self.h[curr].importance
            
            for sub in self.h[curr].subordinates:
                q.appendleft(sub)
            
        return self.result