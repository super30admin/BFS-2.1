"""690. Employee Importance
Time Complexity  -O(N)
Space Complexity - O(N)

Approach ->BFS and hashmap"""
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
        from collections import deque
        hmap = {}
        queue = deque()
        for emp in employees:
            hmap[emp.id] = emp
        
        result = 0
        queue.append(id)
        while queue:
            curr_id = queue.popleft()
            emp =hmap[curr_id]
            result +=emp.importance
            for subord_id in emp.subordinates:
                queue.append(subord_id)
        return result
            
            
        