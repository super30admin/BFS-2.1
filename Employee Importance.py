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
    #Solution 1
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        #Approach: DFS
        #Time Complexity: O(n)
        #Space Complexity: O(n) #empMap
        
        empMap = {} #emp -> (int 'value', list 'direct subordinates')
        for emp in employees:
            empMap[emp.id] = emp
        
        de = deque()
        de.append(id)
        
        total_value = 0
        while de:
            popped = de.popleft()
            emp = empMap[popped]
            total_value += emp.importance
            for sub in emp.subordinates:
                de.append(sub)
        
        return total_value
    
    #Solution 2
    """
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        #Approach: DFS
        #Time Complexity: O(n)
        #Space Complexity: O(n) #empMap
        
        self.empMap = {} #emp -> (int 'value', list 'direct subordinates')
        for emp in employees:
            self.empMap[emp.id] = emp
            
        return self.dfs(id)
    
    def dfs(self, id):
        emp = self.empMap[id]
        
        return emp.importance + sum(self.dfs(sub) for sub in emp.subordinates)
    """