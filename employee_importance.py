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
        emap = {e.id: e for e in employees}
        # print(emap  )
        # print( emap[id].id )
        stack = [] 
        # print(id)
        stack.append( emap[id] )
        # print(q)
        result = 0
        visited = []
        while stack:
            curr = stack.pop()
            # print( curr )
            # print(curr.id, curr.importance , curr.subordinates )
            if curr not in visited:
                # print("curr.importance", type(curr.importance))
                result += curr.importance
                visited.append(curr)
                for subordinate in curr.subordinates:
                    stack.append(emap[subordinate])
            elif curr in visited:
                continue
        return result    
        
'''
Algorithm:
I create a dictionary with emp id : emp object
I push the given id's emp class to a stack 
Iterate until stack is empty and do a BFS and add all the subordinate's importance to a variable called result 

Time Complexity = O(N)
Space Complexity = O(N)
'''
       
