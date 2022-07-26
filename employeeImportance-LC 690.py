# Time Complexity = O(n), number of subordinates
# Space Complexity = O(n), adj List stores all n nodes/employees

"""
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""
# DFS Solution
class Solution:
    def getImportance(self, employees: list['Employee'], id: int) -> int:
        if employees == None or len(employees) == 0:
            return 0
        
        self.totalImp = 0
        
        # Adjacency list - contains key as employee id and values as an employee object since we need to check and calculate for the importance of its subordinates too
        # Better to reference the employee object, than to store the subordinate, importance in a list for values, as it occupies more space.
        self.adjList = {}
        for e in employees:
            self.adjList[e.id] = e
        
        self.dfs(id)
        
        return self.totalImp
    
    
    def dfs(self, id):
        # Base Case
        if id == None:
            return 
            
        # Logic
        # Extracting the employee object for each id
        emp = self.adjList.get(id)
        
        # Can use the below condition here, instead of our base case
        #if emp != None:
        
        # Increment the total importance as you traverse
        self.totalImp += emp.importance
        
        # Do a DFS for each subordinates in the list
        for sub in emp.subordinates:
            self.dfs(sub)

'''



# Using BFS
# TC = O(n)
# SC = O(n)
class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        if employees == None or len(employees) == 0:
            return 0
        
        self.totalImp = 0
        
        self.adjList = {}
        for e in employees:
            self.adjList[e.id] = e
            
        q = []
        q.append(id)
        
        
        while q:
            size = len(q)
            for i in range(size):
                curr = q.pop(0)
                emp = self.adjList.get(curr)
                self.totalImp += emp.importance
                for sub in emp.subordinates:
                    q.append(sub)
                    
        
        return self.totalImp
            
                    
'''       