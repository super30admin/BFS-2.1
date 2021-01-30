#Time Complexity:O(V+E)
#Space Complexity:O(V)

#DFS approach

"""
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""

class Solution:
    global dict                                             #declaring a hashmap
    result=0                                                #declaring the result variable
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        if not employees:                                   #if employees is empty resturn result
            return self.result 
        self.dict={}                                        
        for emp in employees:                               #initializing the hash map with the employee details
            self.dict[emp.id]=emp
        self.dfs(id)                                        #calling the recursive dfs function on the given id
        return self.result                                  #return result
    
    def dfs(self,id:int)->None:
        e=self.dict[id]                                     #obtain the details of the employee from given id from the hash map
        self.result+=e.importance                           #add the importance of the employee to the result
        for sub in e.subordinates:                          #call the dfs function on all their subordinates.
            self.dfs(sub)

#BFS Approach

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
        result=0                                                #initialize the result variable
        if not employees:                                       #if the employee list is empty return result
            return self.result
        dict={}                                                 #declaring a hashmap
        for emp in employees:                                   #populate the hashmap with the employee details
            dict[emp.id]=emp
        d=deque()                                               #declaring a queue
        d.append(id)                                            #append the given id to the queue
        while d:                                                #while the queue is not empty
            empid=d.popleft()                                   #obtain the queue element one after another
            emp=dict[empid]                                     #obtain the emplyee details from hashmap
            result+=emp.importance                              #add the importance of employee to the result
            for sub in emp.subordinates:                        #for every subordinate of an employee add the subordinate id to the queue to be processed.
                d.append(sub)
        return result                                           #return the final result variable
