"""
Problem 2

Employee Impotance(https://leetcode.com/problems/employee-importance/)

"""
"""
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""
from collections import defaultdict
from collections import deque

class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        """
        using adjacenecy list and queue; list to keep track of emp id with emp object and queue to process each id
        Time Complexity : O(v), number of vertices
        Space Complexity: O(v) using hashmap

        """
        # creating a adjacency list
        emp_map = defaultdict()
        q = deque()
        res = 0
        
        for e in employees:
            emp_map[e.id] = e
            
        q. append(id)    
        while q:
            curr_eid = q.popleft()
            emp = emp_map.get(curr_eid)
            res += emp.importance
            
            for subid in emp.subordinates:
                q.append(subid)
            
        return res

# Approach - 2
"""
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""
from collections import defaultdict
from collections import deque

class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        """
        Uisng DFS
        Time complexity : O(V)
        Space Complexity : O(V)
        """
        # creating a adjacency list
        emp_map = defaultdict()
        q = deque()
        self.res = 0    
        
        
        for e in employees:
            emp_map[e.id] = e
            
        def dfs_helper(eid):
            e = emp_map.get(eid)
            self.res += e.importance
            
            for subid in e.subordinates:
                dfs_helper(subid)
        
        dfs_helper(id)    
        return self.res
       
        
        
        
       
        
        
        