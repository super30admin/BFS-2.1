# Time Complexity: 
# Space Complexity:
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
"""
First a hashmap of each employee and their nodes. The total importance is calculated by adding the importance of 
employees in the queue and also adding the subordinates of the employee to the queue. Finally the importance is returned.
"""

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
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        # BFS
        if employees == None or len(employees) == 0 or id == None: return 0

        importance = 0
        hashmap = {employee.id: employee for employee in employees}
        q = deque()
        q.append(hashmap[id])

        while q:
            curr = q.popleft()
            for i in curr.subordinates:
                q.append(hashmap[i])
            importance += curr.importance

        return importance