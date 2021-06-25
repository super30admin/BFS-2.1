# BFS Solution:
# // Time Complexity : O(V+E)
# // Space Complexity : O(V+E)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
#
#
# // Your code here along with comments explaining your approach
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates

#BFS
class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        result = 0
        hashmap = {}
        for e in employees:
            hashmap[e.id] = e
        q = deque()
        q.append(id)
        while q:
            eid = q.popleft()
            e = hashmap[eid]
            result += e.importance
            for subid in e.subordinates:
                q.append(subid)
        return result

#DFS  Solution
# // Time Complexity : O(V+E)
# // Space Complexity : O(V+E)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
#
#
# // Your code here along with comments explaining your approach

# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates


class Solution:
    def __init__(self):
        self.result = 0
        self.hashmap = {}

    def getImportance(self, employees, id):
        for e in employees:
            self.hashmap[e.id] = e
        self.dfs(id)
        return self.result

    def dfs(self, id):
        # logic
        e = self.hashmap[id]
        self.result += e.importance
        for subid in e.subordinates:
            self.dfs(subid)
