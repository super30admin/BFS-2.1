// Time Complexity : O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


/*
// Definition for Employee.
class Employee {
public:
    int id;
    int importance;
    vector<int> subordinates;
};
*/

class Solution {
public:
    int getImportance(vector<Employee*> employees, int id) {
        if(employees.empty() || employees.size() == 0)
            return 0;
        unordered_map<int, Employee*> map;
        for(Employee* emp: employees)
            map.insert({emp->id, emp});
        //BFS
        queue<int> q;
        q.push(id);
        int total =0;
        while(!q.empty()){
            int curr = q.front();
            q.pop();
            Employee* e = map[curr];
            total += e->importance;
            vector<int> subs = e->subordinates;
            if(!subs.empty()){
                for(int sub: subs){
                    q.push(sub);
                }
            }
        }
        return total;
    }
};



// Time Complexity : O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
public:
    unordered_map<int, Employee*> map;
    int total;
    int getImportance(vector<Employee*> employees, int id) {
        if(employees.empty() || employees.size() == 0)
            return 0;
        for(Employee* emp: employees)
            map.insert({emp->id, emp});
        dfs(id);
        return total;
    }
    void dfs(int id){
        //base
        
        //logic
        Employee* e = map[id];
        total += e->importance;
        vector<int> subs = e->subordinates;
        if(!subs.empty()){
            for(int sub: subs){
                dfs(sub);
            }
        }
    }
};
