# Solution using BFS
# Time and space complexity : O(V+E) & O(V)
"""
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""
from queue import Queue
class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        q = Queue()             # A queue for storing Employee's ID's (eid)
        hashmap = {}
        for e in employees:     # Storing a pair of employee id to a reference pointer of employees (eid:e*)
            hashmap[e.id]= e
        print(hashmap)      
        q.put(id)           # Putting initial employees id into q
        print(id)
        total = 0           # To take the count of total importance
        while not q.empty(): # While all the subordinates are not over
            eid = q.get()   # Getting the nodes (Employee id) out of the queue
            e = hashmap.get(eid) # Storing employee reference in the e for corresponding eid
            total += e.importance # Calculating the total importance
            for subId in e.subordinates: # For the given employee put all the id's of its subordinates into the queue
                q.put(subId)
        return total

