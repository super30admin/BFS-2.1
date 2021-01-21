# TC: O(V+E)
# SC: O(V+E)
# DFS
# 1. Maintain hashmap for adjacency list which helps in navigation to child/ subordinate nodes
# 2. Starting point- start with the specified id, traverse as required 
# 3. In the hashmap maintain entire object as we need multiple values from the object through cycle
# 4. Follow up- if cycle exits(multiple managers): maintain visted set or add a var in the hashmap itself
class Solution:
    def __init__(self):
        self.res = 0
        self.hashmap = {}
        
    def getImportance(self, employees, id):
        if employees == None or len(employees) == 0: return self.res
        for e in employees:
            self.hashmap[e.id] = e
        self.dfs(id)
        return self.res
    
    def dfs(self, id):
        #logic
        e = self.hashmap[id]
        self.res += e.importance
        for subId in e.subordinates:
            self.dfs(subId)

#BFS
# maintain queue of employees at each level considered. size not required as we are only concerned with calculation of total count not bothered about each level contribution
from collections import deque
class Solution:
    def getImportance(self, employees, id):
        res = 0
        if employees == None or len(employees) == 0: return res
        hashmap = {}
        for e in employees:
            hashmap[e.id] = e
        q = deque()
        q.append(id)
        while q:
            eid = q.popleft()
            e = hashmap[eid]
            res += e.importance
            for subId in e.subordinates:
                q.append(subId)
        return res