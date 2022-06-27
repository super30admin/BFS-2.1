#Approach - BFS
#Time complexity : O(V+E) i.e. we are going over particular employee and then getting all the subpart of tree from it. Here vertex is employee id and E is not there as subordinates are not connected to other employee i.e. it becomes O(V)
#Space complexity : O(V) i.e.we are storing all employee id with the object in hashmap and the size of the queue i.e it becomes O(2V)
#Did this code successfully run on Leetcode : Yes
#youtube : https://www.youtube.com/watch?v=lMaZpCmcMfA
class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        #here sptoring employee id as the key for the hashmap and emp i.e whole one object reference of the emp as the value
        hashmap = {emp.id : emp for emp in employees}
        #putting total value of importance for giving particular employee
        result =0
        #defining queue for putting the given employee id and further processing for the surbordinates of given employee
        queue = deque()
        #adding the given employee information to the queue
        queue.append(id)
        #while loop will work till all the id from the queue is pop out
        while queue:
            #processing the subtree from the id pop out
            currentId = queue.popleft()
            #fetching the particular id object of employee from hashmap
            e = hashmap[currentId]
            #adding the importance of the fetched employee to the result
            result += e.importance
            #further adding the subordinates of the current employee in the queue
            for sub in e.subordinates:
                queue.append(sub)
        return result
