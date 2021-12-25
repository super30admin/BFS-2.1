class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates

# BFS Approach
class Solution:
    # Time Complexity - O(n)
    # Space Complexity - O(V) as we have n vertices (employees) which is the size of the list
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        if employees is None or len(employees) == 0:
            return 0
        d = {}
        for emp in employees:
            d[emp.id] = emp

        q = deque()
        q.append(id)
        total = 0

        while len(q):
            eid = q.popleft()
            obj = d[eid]
            total += obj.importance
            for sub in obj.subordinates:
                q.append(sub)

        return total


# DFS Approach
class Solution:
    # Time Complexity - O(n)
    # Space Complexity - O(V) where V is the size of the list
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        self.total = 0
        if employees is None or len(employees) == 0:
            return 0
        self.d = {}
        for emp in employees:
            self.d[emp.id] = emp

        self.dfs(id)

        return self.total

    def dfs(self, id):
        obj = self.d[id]
        self.total += obj.importance
        for sub in obj.subordinates:
            self.dfs(sub)