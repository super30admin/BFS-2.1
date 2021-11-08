# 690. Employee Importance
# https://leetcode.com/problems/employee-importance/

# Logic: Make and Adj_list of id vs employee object. 
# Find the target id in the adj list and then add its subordinates to the queue. 
# Pop the element and update the importance value.

# Time Complexiety: O(n)
# Space Complexiety: O(n)

"""
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""
# Using BFS
class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        adj_list = dict()
        importance = 0
        
        # Make Adj list with id as key and employee as value
        for emp in employees:
            adj_list[emp.id] = emp
        
        q = list()
        q.append(id)
        
        while q:
            node = q.pop(0)
            importance += adj_list[node].importance
            
            for i in adj_list[node].subordinates:
                q.append(i)
        
        return importance