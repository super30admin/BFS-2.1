#Time complexity is: O(V) where v is the number of vertices
#Space complexity is: O(V)
#Code ran successfully on leetcode
#No issues faced while developing the code

"""
# Definition for Employee.
class Employee(object):
    def __init__(self, id, importance, subordinates):
    	#################
        :type id: int
        :type importance: int
        :type subordinates: List[int]
        #################
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""
import collections
class Solution(object):
    def getImportance(self, employees, id):
        """
        :type employees: List[Employee]
        :type id: int
        :rtype: int
        """
        #Creating a queue and hashmap
        self.q=collections.deque()
        self.map={}
        #We willbe iterating through the employess and we will adding key as emp id and value as the reference
        for e in employees:
            self.map[e.id]=e
        self.q.append(id)
        #Creating total variable to take note of importance
        total=0
        #We will popping the value from queue, we will be taking the importance and we will be 
        #adding the subordinates to the queue
        while(len(self.q)):
            eid=self.q.popleft()
            e=self.map[eid]
            total+=e.importance
            for subid in e.subordinates:
                self.q.append(subid)
        #Finally, we are returning the total importance
        return total



