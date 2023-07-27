#Time complexity is: O(V) where v is the number of vertices
#Space complexity is: O(V)
# Here, Iterate over employees and store emp_id as key and emp as val and then add id we need to find to the queue.
# Then, till q is empty, get ID from q and get employee name from the map and use this to get it's importance. Then, add all subordinates ID to q and repeat.
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
        map_e={}
        q=deque()
        total=0

        for e in employees: #Iterate over employees and store emp_id as key and emp as val
            map_e[e.id]=e
        q.append(id) #add the id we need to find to the queue

        while q: #here, we do it till we can't anymore subordinates and not based on current size of the queue so use While loop.
            curr_e_id=q.popleft()
            e=map_e[curr_e_id]  #get employee from map using the ID
            total+=e.importance
            for subordinate_id in e.subordinates: #now, for all it's subordinates add them to queue
                q.append(subordinate_id)
        return total
        