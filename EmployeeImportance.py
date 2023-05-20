## Problem 2

# Employee Impotance(https://leetcode.com/problems/employee-importance/)

# Time Complexity: O(n)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode: Yes
# Approach: BFS

class Solution:

    def getImportance(self, employees: List['Employee'], id: int) -> int:
        if not employees:
            return 0
        result = 0
        hashmap = {}
        for e in employees:
            hashmap[e.id] = e
        queue = deque()
        queue.append(id)
        while queue:
            curr = queue.popleft()
            result += hashmap[curr].importance
            for sub in hashmap[curr].subordinates:
                queue.append(sub)
        return result