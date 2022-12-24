#Time Complexity :  O(V + E)
#Space Complexity :  O(V + E)
#Did this code successfully run on Leetcode : Yes

#code along with comments 

#DFS
class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        hashmap = { emp.id: emp for emp in employees}               #creating hashmap where key is id and val is employee object
        
        def dfs(id):
            result = hashmap[id].importance                         #storing the first employee's importance value in result
            for sub in hashmap[id].subordinates:                    #getting the values in subordinates list
                result += dfs(sub)                                  #recursively calling dfs on each subordinate id and adding to result
            return result
        
        return dfs(id)


#BFS
class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        hashmap = { emp.id: emp for emp in employees}               #creating hashmap where key is id and val is employee object
        result = 0
        queue = deque([id])                                         #creating queue and initializing it with the id
        
        while queue:
            id = queue.popleft()
            result += hashmap[id].importance                        #get the importance of first employee add to result
            
            for sub in hashmap[id].subordinates:                    #get the subordinates's id and add it to queue
                queue.append(sub)
        
        return result