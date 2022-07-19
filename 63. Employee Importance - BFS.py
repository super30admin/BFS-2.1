from collections import deque

# BFS
class Solution:
    def getImportance(self, employees, id) -> int:
        result = 0
        m = {}
        for e in employees:
            # print(e.id,
            #      e.importance,
            #      e.subordinates)
            m[e.id] = e

        q = deque()
        q.append(id)

        while q:
            eid = q.popleft()
            e = m.get(eid)
            result += e.importance
            for subid in e.subordinates:
                q.append(subid)

        return result


# BFS
# TC = O(V + E)
# Space complexity : O(V).
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No
