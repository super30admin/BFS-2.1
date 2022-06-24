# time complexity is o(n), where n is the size of the input
# space complexity is o(n), where n is the size of the input
# we can say
# time complexity is o(V+E), where V,E are the number of edges and vertices in the graph
# space complexity is o(V+E), where V,E are the number of edges and vertices in the graph 
"""
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""

class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
    #         bfs
        d = dict()
        result = 0
        for e in employees:
            if(e.id not in d):
                d[e.id] = e
        from collections import deque
        q = deque()
        q.append(id)
        while(len(q) != 0):
            curr = q.popleft()
            curremp = d[curr]
            result += curremp.importance
            for sub in curremp.subordinates:
                q.append(sub)
        return result
    
    
    
#     dfs
# time complexity is o(n), where n is the size of the input
# space complexity is o(n), where n is the size of the input
# we can say
# time complexity is o(V+E), where V,E are the number of edges and vertices in the graph
# space complexity is o(V+E), where V,E are the number of edges and vertices in the graph

#     result = 0
#     def getImportance(self, employees: List['Employee'], id: int) -> int:
#         d = dict()
#         for e in employees:
#             if(e.id not in d):
#                 d[e.id] = e
#         self.dfs(id, d)
#         return self.result
    
#     def dfs(self, id, d):
#         emp = d[id]
#         self.result += emp.importance  
#         for sub in emp.subordinates:
#             if(sub != None):
#                 self.dfs(sub, d)
        
    
    
        
        
        

            
            
        
        