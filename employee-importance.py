# Time Complexity: O(n)
# Space Complexity: O(n)
"""
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""
# DFS
class Solution:
    # Maintain the result and dictionary in the global scope
    def __init__(self):
        self.d = {}
        self.result = 0
    
    # Obtain the employee from the dictionary with id
    # Add the importance to result
    # Traverse the subordinates
    def dfs(self, id):
        # No Base case as for loop is handling the recursion
        #Logic
        e = self.d[id]
        self.result += e.importance
        for subid in e.subordinates:
            self.dfs(subid)
    
    
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        # Base condition check
        if employees == None or len(employees) == 0:
            return 0
        
        # Loop through employees to create a dictionary
        for emp in employees:
            self.d[emp.id] = emp
        
        # Call the dfs function with id
        self.dfs(id)
        
        return self.result
    
    

# BFS
# Time Complexity: O(n)
# Space Complexity: O(n)
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
        # Null condition check
        if employees == None or len(employees) == 0:
            return 0
        
        # Declare a queue
        q = deque()
        q.append(id)
        result = 0
        d = {}
        
        # Create a dictionary with employee id as key and object as value
        for emp in employees:
            d[emp.id] = emp
            
        # Here we dont need the size because we need to process all the ids
        while q:
            # Obtain the id from queue
            # Obtain the object from dictionary
            # Add the importance to result
            eid = q.popleft()
            e = d[eid]
            result += e.importance
            
            # Append the subid to the queue
            for subid in e.subordinates:
                q.append(subid)
                
        return result
                
            
        
            