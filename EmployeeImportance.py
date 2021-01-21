# Time Complexity : O(V)
# Space Complexity : O(V)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :

# Your code here along with comments explaining your approach
# Using BFS. Initialize a queue with the given employee id
# Create a HashMap of each employee with key as id and value as Employee object of id, importance and subordinates
# Iterate over the queue until it is empty and pop the first id from the queue
# Check if that id is in HashMap and append its importance to res and subordinates to the queue
# Append the importance to res for each subordinates until we find the importance of all the subordinates and return res
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
        if not id:
            return 0
        queue = deque([id])
        dict = {}
        res = 0
        for e in employees:
            dict[e.id] = e
        while queue:
            for i in range(len(queue)):
                id = queue.popleft()
                if id in dict:
                    employee = dict[id]
                    res += employee.importance
                    queue.extend(employee.subordinates)

        return res
