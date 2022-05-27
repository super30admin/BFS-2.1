#Approach: BFS
#Mapping employee object to its ID for O(1) search, appending object and adding their and its subordinate's importance
#Time Complexity O(V+E) where V is nodes of Employees and E is connections to subordinates
#Space Complexity O(V+E)
#It successfully runs on leetcode 

from collections import deque
class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        if not employees: return 0
        l={}
        q= deque()
        for i in employees:
            l[i.id]= i
        q.append(l[id])
        imp=0
        while q:
            for i in range(len(q)):
                cur = q.popleft()
                imp+=cur.importance    
                for i in cur.subordinates:
                    q.append(l[i])
        return imp

#Approach: DFS
#Mapping employee object to its ID for O(1) search,soing dfs on each object and its subordinate's
#Time Complexity O(V+E) where V is nodes of Employees and E is connections to subordinates
#Space Complexity O(V+E)
#It successfully runs on leetcode 

from collections import deque
class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        if not employees: return 0
        l={}
        for i in employees:
            l[i.id]= i
        if not l.get(id): return 0 
        self.result = l[id].importance
        self.dfs(l,l[id])
        return self.result
        
    def dfs(self,l, e):
        if not e.subordinates: return self.result
        for i in e.subordinates:
            self.result+=l[i].importance
            self.dfs(l,l[i])