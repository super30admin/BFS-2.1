#
# @lc app=leetcode id=690 lang=python3
#
# [690] Employee Importance
#

# @lc code=start
"""
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""
'''
Time Complexity - O(n) for both DFS and BFS.
Space Complexity - O(n) for BFS and O(h) for DFS

This code works on leetcode
'''
from collections import deque
class Solution:
    def __init__(self):
        self.totImp = 0
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        empMap = {} 
        for employee in employees:
            empMap[employee.id] = employee # empid -> employee object hashMap
        # self.dfs(empMap, id)
        #BFS
        q = deque() 
        q.append(id)#add to queue
        while q: #while queue is not empty
            employee = empMap[q.popleft()] #pop the first employee
            self.totImp+=employee.importance #add importance
            if len(employee.subordinates) > 0: #add subordinates to queue if any
                for subordinate in employee.subordinates:
                    q.append(subordinate)
        return self.totImp #return total importance


    def dfs(self, empMap, id):
        employee = empMap[id] #take employee
        self.totImp+=employee.importance #add its importance
        for i in range(len(employee.subordinates)):
            self.dfs(empMap, employee.subordinates[i]) #take every subordinate process until we do not find any subordinates
        
        
        
# @lc code=end

