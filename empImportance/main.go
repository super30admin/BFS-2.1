/**
 * Definition for Employee.
 * type Employee struct {
 *     Id int
 *     Importance int
 *     Subordinates []int
 * }
 */

/*
    Connected components!
    We have 1 starting point (id)
    We need to then expand from that 1 starting point to all of the subordinates
    
    
    approach: 1
    - BFS
    - We will go search for the id in the emp list to find our starting obj
    - Then might as well make the queue<emp>
    - Once we have our starting point enqueued, then process BFS
    - We can take a queueSize but not needed in this case... but it does not hurt
    - We will also have a imp var at the top ( in which we will sum all imp of starting + all subs imp )
    - When we process an item from our queue , we can easily get the imp of current emp. 
    - We cannot easily get subs importance for the current emp being processed because its a []int ids, ( only if we it was []emp - we would have enqueued all of them )
    - Which forces us to do 2 things
        1. Search each sub over and over again (horrible idea)
        2. Initially, create a map mapping empID : empObj
    - We can use a {empID: empObj} map to easily lookup each sub id emp obj and enqueue it that way.
    - And then rinse and repeat
    
    Time: o(v+e) - worse case we end up processing all subs if the given emp ID has all subs possible.
    Space: o(n) - worse case we end up adding all subs for a given emp ID
    

*/

func getImportance(employees []*Employee, id int) int {
    
    if employees == nil || len(employees) == 0 {
        return 0
    }
    
    empMap := map[int]*Employee{}
    q := []*Employee{}
    imp := 0
    
    for i := 0; i < len(employees); i++ {
        emp := employees[i]
        if emp.Id == id {
            q = append(q, emp)
        }
        empMap[emp.Id] = emp
    }
    
    
    // bfs
    for len(q) != 0 {
        dq := q[0]
        q = q[1:]
        imp += dq.Importance
        for _, subId := range dq.Subordinates {
            q = append(q, empMap[subId])
        }
    }
    
    return imp
}


// time: o(v+e)
// space: o(v) ; worst case we start from root employee and its subordinates are perfectly skewed 
func getImportance(employees []*Employee, id int) int {
    empMap := map[int]*Employee{}
    for i := 0; i < len(employees); i++ {
        empMap[employees[i].Id] = employees[i]
    }
   
    var dfs func(id int) int
    dfs = func(id int) int {
        // base
        
        // logic
        emp := empMap[id]
        importance := emp.Importance
        for i := 0; i < len(emp.Subordinates);  i++ {
            importance += dfs(emp.Subordinates[i])
        }
        return importance
    }
    return dfs(id)
}
