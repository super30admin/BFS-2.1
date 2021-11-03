
# Time Complexity : O(n) 
# Space Complexity : O(n) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        emp_map = {}
        for i in employees:
            emp_map[i.id] = i
        q = deque()
        q.append(id)
        result = 0
        while q:
            curr_id = q.popleft()
            e = emp_map[curr_id]
            result += e.importance
            for s in e.subordinates:
                q.append(s)
        return result
