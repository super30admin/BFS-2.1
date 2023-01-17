#DFS
# Time Complexity : O(V+E), number of vertices :  here,V=E
# Space Complexity: O(V+E) using hashmap
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
        emp_map = defaultdict()
        self.res = 0

        for e in employees:
            emp_map[e.id] = e
                
        def dfs(id):
            e = emp_map.get(id)
            self.res += e.importance
            for subid in e.subordinates:
                dfs(subid)
        dfs(id)
        return self.res

#BFS
# using adjacenecy list and queue; list to keep track of emp id with emp object and queue to process each id
# Time Complexity : O(V+E), number of vertices
# Space Complexity: O(V+E) using hashmap
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
        emp_map = defaultdict()
        q = deque()
        q.append(id)

        for e in employees:
            emp_map[e.id] = e
        
        res = 0
        while q:
            eid = q.popleft()
            e = emp_map.get(eid)
            res += e.importance
            for subid in e.subordinates:
                q.append(subid)
        return res
