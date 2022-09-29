"""
FAANMG Problem #64 {Easy}

690. Employee Importance

Time Complexity : O(N)


Space Complexity : O(N)


Did this code successfully run on Leetcode : Yes

BFS Solution

@name: Rahul Govindkumar_RN27JUL2022
"""

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
        
        hashmap ={}
        
        # store the objects in the Hashmap
        for e in employees:
            hashmap[e.id]=e
            
        result =0
        
        # start with id as the queue
        q = collections.deque()
        q.append(id)
        
        while q:
            # pop the element from the queue
            e_id = q.popleft()
            e = hashmap[e_id]
            
            # add the importance value of that employee
            result += e.importance
            
            # add subordinates to the queue for that employee
            for sub_id in e.subordinates:
                q.append(sub_id)
                
        return result
                
"""
FAANMG Problem #64 {Easy}

690. Employee Importance

Time Complexity : O(N)


Space Complexity : O(N)


Did this code successfully run on Leetcode : Yes

DFS Solution

@name: Rahul Govindkumar_RN27JUL2022
"""
"""
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""

class Solution:
    
    def dfs(self,eid):
        
        #base
        
        #logic
        e=self.hashmap[eid]
        
        # add the importance value of that employee
        self.result +=e.importance
        
        for subid in e.subordinates:
            self.dfs(subid)
        
        
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        
        self.hashmap ={}
        
        # store the objects in the Hashmap
        for e in employees:
            self.hashmap[e.id]=e
            
        self.result =0
        
        self.dfs(id)
        
        return self.result
                
            
            
            
            
        
        
        
            
            
            
            
        
        
        