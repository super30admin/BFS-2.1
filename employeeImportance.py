# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Nope


# Your code here along with comments explaining your approach

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
        """
        Can do BFS on employees..
        - Use a hashmap that has ID : 'employees' ( the employee object)
        
        since we need to find the importance of the ID we put it into a queue and do BFS
            - get the employeeID and extract the importance and add it to a res as well as 
            check the subordinates. 
        
        return res
        """
        res = 0
        if not employees:
            return res
        
        mapping = defaultdict()
        
        for employee in employees:
            mapping[employee.id] = employee
        
        queue = deque([id])
        
        while queue:
            eid = queue.popleft()
            employee = mapping[eid]
            res += employee.importance 
            
            #gotta check the employee's subordinates 
            for subIds in employee.subordinates:
                queue.append(subIds)
                
        return res
        