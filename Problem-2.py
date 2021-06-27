"""
Approach: do either BFS or DFS and keep adding importance along the way

For both approaches:
TC: O(n) can also say O(V+E)
SC: O(n)
"""

from collections import deque
class Solution:
    # approach 1 : DFS
    """
    def __init__(self):
        self.result = 0

    def getImportance(self, employees: List['Employee'], id: int) -> int:
        hashmap = {}
        for e in employees:
            hashmap[e.id] = e

        self.dfs(id, hashmap)
        return self.result

    def dfs(self, id, hashmap):
        emp = hashmap[id]
        self.result += emp.importance
        subordinates = emp.subordinates
        for e in subordinates:
            self.dfs(e, hashmap)
    """

    # approach 2: BFS
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        result = 0
        hashmap = {}
        for e in employees:
            hashmap[e.id] = e
        q = deque()
        q.append(id)
        while q:
            curr_id = q.popleft()
            emp = hashmap[curr_id]
            result += emp.importance
            subordinates = emp.subordinates
            for e_id in subordinates:
                q.append(e_id)
        return result