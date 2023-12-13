# Time Complexity : O(V+E)
# Space Complexity : O(1) as we already have the imput given in a list, 
# we are just storing pointers to those employees in the hashmap
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach

# iterate over the employees list in a bfs manner starting from the 
# id given in the function and going over the subordinates of each employee, 
# where the mapping from eid to employee is stored in a map
# just add the importances and return the result


from collections import deque

class Employee:
    def __init__(self, id, importance, subordinates):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates

class Solution:

    def getImportance(self, employees, id):

        result = 0
        mydict = {}
        for e in employees:
            mydict[e.id] = e
        
        q = deque()
        q.append(id)

        while len(q) != 0:

            curr = q.popleft()
            eid = mydict[curr]
            result += eid.importance
            for sub in eid.subordinates:
                q.append(sub)
        
        return result