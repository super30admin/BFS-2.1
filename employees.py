#Time : 0(N)
#Space: 0(N)


"""
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""


class Solution:
    
  #DFS  
    def dfs(self, id):
        
        e = self.empDict.get(id)
        self.result = self.result + e.get("importance")
        for s in e.get("subordinates"):
            self.dfs(s)
    
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        
        #DFS SOLUTION
        self.empDict = {}
        self.result = 0
        
        # print(employees)
        
        for emp in employees:
            self.empDict[emp.id] = {"empid" : emp.id,
                              "importance" : emp.importance,
                              "subordinates" : emp.subordinates}
        
        self.dfs(id)
        return self.result
        
    #BFS SOLUTION    
#         empDict = {}
#         result = 0
        
#         # print(employees)
        
#         for emp in employees:
#             empDict[emp.id] = {"empid" : emp.id,
#                               "importance" : emp.importance,
#                               "subordinates" : emp.subordinates}
            
#         q = collections.deque()
#         q.append(id)
#         result = result + empDict.get(id).get("importance")
        
#         while(q):
            
            
#             subList = empDict[q.popleft()]["subordinates"]
            
            
#             for s in subList:
#                 q.append(s)
#                 result = result + empDict.get(s).get("importance")
                
        
#         return result
        
