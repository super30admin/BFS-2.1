# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Your code here along with comments explaining your approach
	# Maintain an adjacency List
	# run BFS or DFS

"""
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""
from  collections import deque
class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        if not employees:
            return 0
        
        Emap ={}
        for emp in employees:
            Emap[emp.id] = emp
        return(self.helper(Emap,id))
    
    def helper(self,Emap,id):
        Importance = Emap[id].importance
        for subs in Emap[id].subordinates:
            Importance += self.helper(Emap,subs)
        return Importance
            
            