'''
690. Employee Importance

APPROACH 1: BFS
TIME COMPLEXITY: O(N), N = size of employees list
SPACE COMPLEXITY: O(N)
LEETCODE: Yes
DIFFICULTIES: Nope, after the class

APPROACH 2: DFS
TIME COMPLEXITY: O(N), N = size of employees list
SPACE COMPLEXITY: O(N)
LEETCODE: Yes
DIFFICULTIES: Nope, after the class

'''

from collections import deque
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
        
        # BFS
        def approach1(employees, id):
            mmap = {}
            
            for employee in employees:
                mmap[employee.id] = employee
            
            q = deque()
            q.append(id)
            
            res = 0
            
            while( len(q)!= 0 ):
                sz = len(q)
                for i in range(0, sz):
                    node = q.popleft()
                    emp_obj = mmap[node]
                    for subordinate in emp_obj.subordinates:
                        q.append(subordinate)
                    res += emp_obj.importance
            return res
        
        # DFS
        def approach2(employees, id):
            global res, mmap
            res = 0
            mmap = {}
            
            for employee in employees:
                mmap[employee.id] = employee
            
            def dfs(id):
                global res, mmap
                
                emp_obj = mmap[id]
                res += emp_obj.importance
                for subordinate_id in emp_obj.subordinates:
                    dfs(subordinate_id)
                
            dfs(id)
            return res
        
        return approach1(employees, id)
        # return approach2(employees, id)
    
